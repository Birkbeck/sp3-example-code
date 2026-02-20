// macro_rules! patterns use fragment specifiers ($x:expr, $x:ident, $x:ty …).
// The * repetition operator matches zero or more occurrences.
// Macros are hygienic — identifiers inside the macro body don't leak into the caller's scope.

// ── vec_of_strings! ──────────────────────────────────────────────────
macro_rules! vec_of_strings {
    ( $( $x:expr ),* ) => {
        {
            let mut v: Vec<String> = Vec::new();
            $( v.push(String::from($x)); )*
            v
        }
    };
    // Allow trailing comma
    ( $( $x:expr ),+ , ) => { vec_of_strings![ $($x),* ] };
}

// ── assert_approx_eq! ────────────────────────────────────────────────
macro_rules! assert_approx_eq {
    ($a:expr, $b:expr, $eps:expr) => {{
        let diff = ($a - $b).abs();
        assert!(
            diff <= $eps,
            "assert_approx_eq failed: |{} - {}| = {} > {}",
            $a,
            $b,
            diff,
            $eps
        );
    }};
    // Default epsilon of 1e-6
    ($a:expr, $b:expr) => {
        assert_approx_eq!($a, $b, 1e-6_f64)
    };
}

// ── sql_query! ───────────────────────────────────────────────────────
macro_rules! sql_query {
    ($table:ident, $( $col:ident = $val:expr ),*) => {{
        let mut conditions = Vec::<String>::new();
        $( conditions.push(format!("{} = '{}'", stringify!($col), $val)); )*
        if conditions.is_empty() {
            format!("SELECT * FROM {}", stringify!($table))
        } else {
            format!("SELECT * FROM {} WHERE {}",
                stringify!($table), conditions.join(" AND "))
        }
    }};
}

fn main() {
    let langs = vec_of_strings!["Rust", "Go", "Zig"];
    println!("{:?}", langs);

    assert_approx_eq!(0.1_f64 + 0.2, 0.3, 1e-10);

    let q = sql_query!(users, name = "Alice", age = 30);
    println!("{}", q);
    // SELECT * FROM users WHERE name = 'Alice' AND age = '30'
}
