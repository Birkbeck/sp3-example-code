use std::io;

fn main() {
    println!("What is your name? ");

    let mut name = String::new();
    io::stdin().read_line(&mut name).expect("No input received");
    println!("Hello {}! {}", name.trim_end(), "Nice to meet you");
}

// in Java
// var str = new String("Help");
