# Example Rust programs

Please review all of the examples.

The examples above `example-16` deal with more complex `Rust` and programming issues.

The examples

+ `bank-account-example`, and
+ `example-20` 

specifically deal with concurrency and are excellent revision for the examination.


## Comparison of `Python` and `Rust` features

| Feature | Python |Rust |
|:------|:------|:-----|
|Variable | x = 5 | let x = 5; (Immutable) |
| Changeable Var | x = 5; x = 6 | let mut x = 5; x = 6; |
| Printing | "print(f""Hi {name}"")" | "println!(""Hi {}"", name);" |
| Lists | "items = [1, 2, 3]" | "let items = vec![1, 2, 3];" |
| Functions | "def add(a, b):" | "fn add(a: i32, b: i32) -> i32 {" |
| Last Line Return | return a + b | a + b (No semicolon = return)|
| For Loop | for i in range(5): |for i in 0..5 {|
| Null/None | None |None (part of the Option enum)|