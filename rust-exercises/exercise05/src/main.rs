// Box<dyn Renderer> stores a fat pointer: 8 bytes for the data pointer + 8 bytes for the vtable pointer.
// This enables runtime polymorphism at the cost of one extra indirection per call.

trait Renderer {
    fn render(&self, content: &str) -> String;
    fn name(&self) -> &str;
}

// ── Concrete implementations ─────────────────────────────────────────
struct HtmlRenderer;
struct MarkdownRenderer;
struct PlainTextRenderer;

impl Renderer for HtmlRenderer {
    fn render(&self, content: &str) -> String {
        format!(
            "<p>{}</p>",
            content.replace('&', "&amp;").replace('<', "&lt;")
        )
    }
    fn name(&self) -> &str {
        "HTML"
    }
}

impl Renderer for MarkdownRenderer {
    fn render(&self, content: &str) -> String {
        format!("**{}**", content)
    }
    fn name(&self) -> &str {
        "Markdown"
    }
}

impl Renderer for PlainTextRenderer {
    fn render(&self, content: &str) -> String {
        content.to_string()
    }
    fn name(&self) -> &str {
        "PlainText"
    }
}

// ── Pipeline ─────────────────────────────────────────────────────────
struct RenderPipeline {
    renderers: Vec<Box<dyn Renderer>>,
}

impl RenderPipeline {
    fn new() -> Self {
        RenderPipeline {
            renderers: Vec::new(),
        }
    }

    fn add(&mut self, r: Box<dyn Renderer>) {
        self.renderers.push(r);
    }

    // Applies each renderer in sequence; output of one feeds the next.
    fn run(&self, input: &str) -> String {
        self.renderers
            .iter()
            .fold(input.to_string(), |acc, r| r.render(&acc))
    }
}

// ── Factory ──────────────────────────────────────────────────────────
fn select_renderer(format: &str) -> Box<dyn Renderer> {
    match format {
        "html" => Box::new(HtmlRenderer),
        "markdown" => Box::new(MarkdownRenderer),
        _ => Box::new(PlainTextRenderer),
    }
}

fn main() {
    // Single renderer selected at runtime
    let r = select_renderer("html");
    println!("{}: {}", r.name(), r.render("Hello <world>"));

    // Pipeline: plain → markdown → html
    let mut pipeline = RenderPipeline::new();
    pipeline.add(Box::new(PlainTextRenderer));
    pipeline.add(Box::new(MarkdownRenderer));
    println!("{}", pipeline.run("Rust"));

    // ── Static vs Dynamic dispatch ─────────────────────────────────
    // impl Renderer → monomorphised at compile time, zero vtable cost.
    // dyn Renderer  → vtable lookup at runtime, one extra indirection.
    // Use impl Trait when the type is known at compile time.
    // Use dyn Trait when you need a heterogeneous collection or when the type is determined at runtime.
}
