// Axum State<T> requires T: Clone — Arc<RwLock<HashMap>> satisfies this because Arc::clone is cheap (atomic increment).
// Handler return types implement IntoResponse, so (StatusCode, Json<T>) tuples work directly.

use axum::{
    Json, Router,
    extract::{Path, State},
    http::StatusCode,
    response::{IntoResponse, Response},
    routing::get,
};
use serde::{Deserialize, Serialize};
use std::{collections::HashMap, sync::Arc};
use tokio::sync::RwLock;
use uuid::Uuid;

// ── Domain types ─────────────────────────────────────────────────────────────

#[derive(Debug, Clone, Serialize, Deserialize)]
#[serde(rename_all = "snake_case")]
enum TaskStatus {
    Todo,
    InProgress,
    Done,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
struct Task {
    id: Uuid,
    title: String,
    description: Option<String>,
    status: TaskStatus,
    created_at: u64,
}

#[derive(Debug, Deserialize)]
struct CreateTaskRequest {
    title: Option<String>,
    description: Option<String>,
}

#[derive(Debug, Deserialize)]
struct UpdateTaskRequest {
    title: Option<String>,
    description: Option<String>,
    status: Option<TaskStatus>,
}

#[derive(Serialize)]
struct ErrorResponse {
    error: String,
}

type AppState = Arc<RwLock<HashMap<Uuid, Task>>>;

// ── Helpers ──────────────────────────────────────────────────────────────────

fn error_response(code: StatusCode, msg: &str) -> Response {
    (
        code,
        Json(ErrorResponse {
            error: msg.to_string(),
        }),
    )
        .into_response()
}

fn now() -> u64 {
    std::time::SystemTime::now()
        .duration_since(std::time::UNIX_EPOCH)
        .unwrap()
        .as_secs()
}

// ── Handlers ─────────────────────────────────────────────────────────────────

// GET /tasks
async fn list_tasks(State(state): State<AppState>) -> Response {
    let tasks: Vec<Task> = state.read().await.values().cloned().collect();
    Json(tasks).into_response()
}

// POST /tasks
async fn create_task(
    State(state): State<AppState>,
    Json(req): Json<CreateTaskRequest>,
) -> Response {
    let title = match req.title {
        Some(t) if !t.is_empty() => t,
        _ => return error_response(StatusCode::UNPROCESSABLE_ENTITY, "'title' is required"),
    };
    let task = Task {
        id: Uuid::new_v4(),
        title,
        description: req.description,
        status: TaskStatus::Todo,
        created_at: now(),
    };
    state.write().await.insert(task.id, task.clone());
    (StatusCode::CREATED, Json(task)).into_response()
}

// GET /tasks/:id
async fn get_task(State(state): State<AppState>, Path(id): Path<Uuid>) -> Response {
    match state.read().await.get(&id).cloned() {
        Some(task) => Json(task).into_response(),
        None => error_response(StatusCode::NOT_FOUND, "Task not found"),
    }
}

// PUT /tasks/:id
async fn update_task(
    State(state): State<AppState>,
    Path(id): Path<Uuid>,
    Json(req): Json<UpdateTaskRequest>,
) -> Response {
    let mut store = state.write().await;
    match store.get_mut(&id) {
        Some(task) => {
            if let Some(t) = req.title {
                task.title = t;
            }
            if let Some(d) = req.description {
                task.description = Some(d);
            }
            if let Some(s) = req.status {
                task.status = s;
            }
            Json(task.clone()).into_response()
        }
        None => error_response(StatusCode::NOT_FOUND, "Task not found"),
    }
}

// DELETE /tasks/:id
async fn delete_task(State(state): State<AppState>, Path(id): Path<Uuid>) -> Response {
    if state.write().await.remove(&id).is_some() {
        StatusCode::NO_CONTENT.into_response()
    } else {
        error_response(StatusCode::NOT_FOUND, "Task not found")
    }
}

// ── Router ───────────────────────────────────────────────────────────────────

fn build_router(state: AppState) -> Router {
    Router::new()
        .route("/tasks", get(list_tasks).post(create_task))
        .route(
            "/tasks/:id",
            get(get_task).put(update_task).delete(delete_task),
        )
        .with_state(state)
}

// ── Entry point ──────────────────────────────────────────────────────────────

#[tokio::main]
async fn main() {
    let state: AppState = Arc::new(RwLock::new(HashMap::new()));
    let app = build_router(state);

    let listener = tokio::net::TcpListener::bind("0.0.0.0:3000").await.unwrap();
    println!("Listening on http://0.0.0.0:3000");
    axum::serve(listener, app).await.unwrap();
}

// ── Tests ────────────────────────────────────────────────────────────────────

#[cfg(test)]
mod tests {
    use super::*;
    use axum::body::Body;
    use axum::http::{Method, Request};
    use tower::ServiceExt; // for .oneshot()

    fn test_app() -> Router {
        let state: AppState = Arc::new(RwLock::new(HashMap::new()));
        build_router(state)
    }

    #[tokio::test]
    async fn test_list_tasks_empty() {
        let app = test_app();
        let req = Request::builder()
            .method(Method::GET)
            .uri("/tasks")
            .body(Body::empty())
            .unwrap();
        let res = app.oneshot(req).await.unwrap();
        assert_eq!(res.status(), StatusCode::OK);
    }

    #[tokio::test]
    async fn test_create_task_success() {
        let app = test_app();
        let body = serde_json::json!({ "title": "Buy milk" }).to_string();
        let req = Request::builder()
            .method(Method::POST)
            .uri("/tasks")
            .header("content-type", "application/json")
            .body(Body::from(body))
            .unwrap();
        let res = app.oneshot(req).await.unwrap();
        assert_eq!(res.status(), StatusCode::CREATED);
    }

    #[tokio::test]
    async fn test_missing_title_returns_422() {
        let app = test_app();
        let req = Request::builder()
            .method(Method::POST)
            .uri("/tasks")
            .header("content-type", "application/json")
            .body(Body::from("{}"))
            .unwrap();
        let res = app.oneshot(req).await.unwrap();
        assert_eq!(res.status(), StatusCode::UNPROCESSABLE_ENTITY);
    }

    #[tokio::test]
    async fn test_get_nonexistent_task_returns_404() {
        let app = test_app();
        let fake_id = Uuid::new_v4();
        let req = Request::builder()
            .method(Method::GET)
            .uri(format!("/tasks/{}", fake_id))
            .body(Body::empty())
            .unwrap();
        let res = app.oneshot(req).await.unwrap();
        assert_eq!(res.status(), StatusCode::NOT_FOUND);
    }

    #[tokio::test]
    async fn test_delete_nonexistent_task_returns_404() {
        let app = test_app();
        let fake_id = Uuid::new_v4();
        let req = Request::builder()
            .method(Method::DELETE)
            .uri(format!("/tasks/{}", fake_id))
            .body(Body::empty())
            .unwrap();
        let res = app.oneshot(req).await.unwrap();
        assert_eq!(res.status(), StatusCode::NOT_FOUND);
    }
}
