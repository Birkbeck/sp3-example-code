// String is a heap-allocated, growable type — it does NOT implement Copy.
// Passing it to a function moves ownership.
// &str is a borrowed reference and never takes ownership.

fn process_string(s: String) -> String {
    // Takes ownership of `s`; the caller cannot use it after this call.
    s.to_uppercase()
}

fn peek_string(s: &str) {
    // Borrows a string slice — the caller's binding remains valid.
    println!("Length: {}", s.len());
}

fn main() {
    let original = String::from("hello, rust");

    // 1. Borrow first so we can still use `original` afterwards.
    peek_string(&original); // passes &String, coerces to &str

    // 2. Move into process_string. `original` is no longer valid here.
    let upper = process_string(original);
    println!("{}", upper); // prints: HELLO, RUST

    // Alternatively: clone to keep the original alive.
    let original2 = String::from("hello again");
    let upper2 = process_string(original2.clone()); // clone → two owners
    peek_string(&original2); // original2 still valid
    println!("{}", upper2);

    // --- Why i32 IS Copy but String is NOT ---
    // i32 is stack-only; copying it is just a memcpy of a few bytes.
    // String owns heap memory: copying would require a fresh allocation,
    // so Rust makes it explicit via .clone() rather than implicit.
    let x: i32 = 5;
    let y = x; // copy — both x and y are valid
    println!("{} {}", x, y);
}

// Key Takeaways
// Pass a &String or &str when you only need to read — no ownership transfer occurs.
// Call .clone() when you genuinely need two independent owned copies.
// Types that are small and entirely stack-resident (i32, bool, f64, etc.) implement Copy automatically; heap-owning types like String do not.
