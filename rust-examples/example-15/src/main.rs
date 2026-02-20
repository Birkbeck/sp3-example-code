// ----- HASH MAPS -----
// Hash maps are used to store key / value pairs

fn main() {
    use std::collections::HashMap; // note local reference to library within the function main

    // Create an empty hash map

    let mut heroes = HashMap::new();

    // Insert in hashmap (To overwrite use the same key)

    heroes.insert("Superman", "Clark Kent");
    heroes.insert("Batman", "Bruce Wayne");
    heroes.insert("The Flash", "Barry Allen");

    // Iterate over hashmap

    for (k, v) in heroes.iter() {
        println!("{} = {}", k, v);
    }

    // Length of hashmap

    println!("Length : {}", heroes.len());

    // Check for key in hashmap

    if heroes.contains_key(&"Batman") {
        // Get value with key
        let the_batman = heroes.get(&"Batman");
        match the_batman {
            Some(_x) => println!("Batman is a hero"),
            None => println!("Batman is not a hero"),
        }
    }
}
