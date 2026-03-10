## Key Points

+ The `&` Symbol:  `&` creates a pointer under the hood, but the compiler guarantees that the pointer always points to valid memory.
+ *Immutability by Default*: The `let my_note` had to become `let mut my_note`. `Rust` assumes you want to be safe unless you explicitly ask for "mutation."
+ The "One Writer" Rule: Question:
    > "What happens if I try to call `add_to_note` while `read_note` is still using the string?" 
  
    Clue: Rust is "Data Race Free."