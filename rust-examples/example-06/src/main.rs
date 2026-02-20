// When defining a function that uses a generic place the name
// inside angled brackets after the function name

// The add trait specifies the functionality of + for different types

use std::ops::Add;

// We get 2 generic types of the same type and return that same type
fn get_sum_gen<T: Add<Output = T>>(x: T, y: T) -> T {
    x + y
}

fn main(){
    println!("get_sum_gen ints = {}", get_sum_gen(3,4));
    println!("get_sum_gen floats = {}", get_sum_gen(3.5,4.3));
    // Try uncommenting the next line and see what error diagnostic you receive
    // So "Add" is not defined on "String"
    println!("get_sum_gen strings = {}", get_sum_gen(&String::from("A"), &String::from("B")));
}