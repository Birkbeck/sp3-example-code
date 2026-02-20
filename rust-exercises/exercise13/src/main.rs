// Custom Serialize/Deserialize implementations give you full control over the wire format.
// The visitor pattern is Serde's approach to format-agnostic deserialisation — the same Deserialize impl works for JSON, TOML, MessagePack, etc.

use serde::{Deserialize, Deserializer, Serialize, Serializer, de::Visitor};
use std::collections::HashMap;
use std::fmt;

// ── Timestamp newtype with custom wire format ─────────────────────────
#[derive(Debug, Clone, PartialEq)]
struct Timestamp(u64); // Unix epoch seconds

impl Serialize for Timestamp {
    fn serialize<S: Serializer>(&self, s: S) -> Result<S::Ok, S::Error> {
        s.serialize_u64(self.0) // serialise as a plain integer
    }
}

struct TimestampVisitor;
impl<'de> Visitor<'de> for TimestampVisitor {
    type Value = Timestamp;
    fn expecting(&self, f: &mut fmt::Formatter) -> fmt::Result {
        f.write_str("a Unix epoch integer")
    }
    fn visit_u64<E: serde::de::Error>(self, v: u64) -> Result<Timestamp, E> {
        Ok(Timestamp(v))
    }
}

impl<'de> Deserialize<'de> for Timestamp {
    fn deserialize<D: Deserializer<'de>>(d: D) -> Result<Self, D::Error> {
        d.deserialize_u64(TimestampVisitor)
    }
}

// ── API structs ───────────────────────────────────────────────────────
#[derive(Debug, Serialize, Deserialize, PartialEq, Clone)]
#[serde(rename_all = "camelCase")]
struct User {
    user_id: u64,
    display_name: String,
    #[serde(skip_serializing_if = "Option::is_none")]
    email: Option<String>,
    created_at: Timestamp,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename_all = "camelCase")]
struct Pagination {
    page: u32,
    per_page: u32,
    total: u64,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
struct ApiResponse<T: Serialize + for<'de2> Deserialize<'de2>> {
    data: T,
    pagination: Option<Pagination>,
    #[serde(flatten)]
    meta: HashMap<String, String>,
}

fn main() {
    let user = User {
        user_id: 42,
        display_name: "Alice".to_string(),
        email: Some("alice@example.com".to_string()),
        created_at: Timestamp(1_700_000_000),
    };

    // Serialize to JSON
    let json = serde_json::to_string_pretty(&user).unwrap();
    println!("{}", json);

    // Round-trip
    let back: User = serde_json::from_str(&json).unwrap();
    assert_eq!(user, back);
    println!("Round-trip OK");

    // User without email — field omitted in output
    let anon = User {
        user_id: 0,
        display_name: "Anon".into(),
        email: None,
        created_at: Timestamp(0),
    };
    let anon_json = serde_json::to_string(&anon).unwrap();
    assert!(!anon_json.contains("email"));
    println!("Email omitted: {}", anon_json);
}
