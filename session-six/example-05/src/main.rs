// Some simple function calls
#![allow(unused)]

fn main() {
    //print_str(String::from("Thing"));

    //let str = print_return_str(String::from("Ouch!"));
    //println!("The same string : {}", str);

    //let mut s = String::from("Carlos");
    //change_string(&mut s);
    //println!("Message : {}", s);

    let numbers = vec![10, 20, 30, 40, 50];
    let sum = sum_list(&numbers);
    println!("Sum of the list {:?} is {}",numbers,sum);
}

fn print_str(x: String) {
    println!("A string {}", x);
}

fn print_return_str(x: String) -> String {
    println!("A string {}", x);
    x
}

fn change_string(name: &mut String) {
    name.push_str(" is Happy");
    println!("Message in change_string : {}", name);
}

// This function sums values in a list (Receives reference to list)
fn sum_list(list: &[i32]) -> i32 {
    let mut sum = 0;
    for val in list.iter() {
        sum += val;
    }
    sum
}
