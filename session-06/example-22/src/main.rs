fn main() {
    let mut my_note = String::from("Hello");

    // We pass a reference (&) instead of the value
    read_note(&my_note); 

    // Now we pass a mutable reference (&mut) to change it
    add_to_note(&mut my_note);

    println!("The final note is: {}", my_note);
}

fn read_note(content: &String) {
    println!("I'm just reading: {}", content);
}

fn add_to_note(content: &mut String) {
    content.push_str(" World!");
}