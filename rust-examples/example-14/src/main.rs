// ----- OWNERSHIP -----
//
// Memory is managed through a system of ownership with
// rules that are checked at compile time.
// To understand this you must understand the Stack & Heap
// Both are parts of memory

// Stack : Stores values in a last in first out format
// Data on the stack must have a defined fixed size

// Heap : When putting data on the heap you request a certain
// amount of space. The OS finds space available and returns
// an address for that space called a pointer.

// RULES
//
// 1. Each value has a variable that's called its owner
// 2. There is only one owner at a time
// 3. When the owner goes out of scope the value disappears

fn main() {
    // While automatic deallocation of resources is great problems
    // can occur. Imagine you copied a string. If you do the string
    // just stores a pointer to the 1st index, the memory required
    // for each character and the number of characters. What happens if
    // we delete one of those strings? That information is deallocated
    // for both strings. That causes a problem called a double free error.
    // Because of that once you copy a string you can no longer access
    // the original as you see here :
    //
    // let str1 = String::from("World");
    // let srt2 = str1;
    // println!("Hello {}", str1);

    // If you want 2 copies use clone

    let str1 = String::from("World");
    let _str2 = str1.clone();
    println!("Hello {}", str1);

    // The above doesn't apply with data types :
    // Integers, bool, char, floats, tuples with the above data types only

    // Here the string was borrowed by the function

    let str3: String = String::from("World");
    print_str(str3);

    // This throws an error because the string was dropped when the
    // function ends
    // println!("str3 = {}", str3);

    // You can avoid this by passing a reference to a variable without
    // transferring ownership (You could also return the variable from
    // the function) (Passing by reference is called Borrowing)

    let str4: String = String::from("World");
    let str5 = print_return_str(str4);
    println!("str5 = {}", str5);

    // If a function borrows a reference it can't change it unless we
    // create a mutable version of it (You can only create one mutable
    // version in the function)

    let mut str6: String = String::from("Kier");
    change_string(&mut str6);
}

// We have seen these functions before...

fn change_string(name: &mut String) { 
    name.push_str(" is Happy");
    println!("Message : {}", name);
}

fn print_str(x: String) {
    println!("A string {}", x);
}

fn print_return_str(x: String) -> String {
    println!("A string {}", x);
    x
}