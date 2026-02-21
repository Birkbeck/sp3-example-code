// You'll get warnings if you have unused variables
//
// This gets rid of them — use sparingly as being informed of unused items
// can avoid various "bugs".

#![allow(unused)]

fn main() {
    //say_hello();
    //get_sum(12,19);
    // The "type" of the variable result is inferred from the return type of the function
    //let result = get_sum_2(15,19); 
    //println!("The result from get_sum_2 is : {}", result); 
    // :#?  "pretty prints" the item
    //println!("The result from get_sum_3 is : {}", get_sum_3(6,9));
    //println!("The result from get_2 is : {:?}", get_2(15));
    // Get multiple values

    let (val_1, val_2) = get_2(3);
    println!("Nums : {} {}", val_1, val_2);
}

// You can define functions before or after main
fn say_hello() {
    println!("Hello");
}

// You can pass arguments to functions
fn get_sum(x: i32, y: i32) {
    println!("{} + {} = {}", x, y, x + y);
}

// Return a value
fn get_sum_2(x: i32, y: i32) -> i32 {
    // This expression is returned
    // If you used a semicolon you'd get an error because
    // a statement don't evaluate to a value
    x + y
}

// You can also use return
fn get_sum_3(x: i32, y: i32) -> i32 {
    return x + y;
}

// Return multiple values
fn get_2(x: i32) -> (i32, i32) {
    (x + 1, x + 2)
}