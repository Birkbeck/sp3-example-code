fn main() {
    let my_note = String::from("Hello");

    destroy_note(my_note);

    // This line causes a compile error!
    println!("Trying to read the note: {}", my_note); 
}

fn destroy_note(content: String) {
    println!("I took the note: {}", content);
} // 'content' goes out of scope and memory is freed here.