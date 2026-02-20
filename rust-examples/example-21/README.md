+ When `my_note` is passed to the function, its ownership moves. 
+ The `main` function no longer "owns" that memory. 
+ In C and Python, you'd still have the pointer and could cause a "use-after-free" bug
+ Rust stops you before you even run the code.