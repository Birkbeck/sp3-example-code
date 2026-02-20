fn main() {
    // ----- TUPLES -----
    // Tuples can contain multiple data types in a list of fixed size
    // We convert to strings with to_string()

    let my_tuple: (u8, String, f64) = (47, "Kier".to_string(), 50_000.00);

    // You can get values by index starting at 0

    println!("Name : {}", my_tuple.1);

    // You can assign values to multiple variables

    let (v1, _v2, _v3) = my_tuple; // deconstructed
    println!("Age : {}", v1);

    // ----- STRINGS -----
    // There are 2 types of strings
    // 1. String : Vector of bytes that can be changed
    // 2. &str : Points to the string and allows for viewing

    // Create an empty growable string

    let mut st1 = String::new();

    // Insert a character at the end of a string

    st1.push('A');

    // Insert a string at the end

    st1.push_str(" word");

    // Iterate through words by splitting at whitespace

    for word in st1.split_whitespace() {
        println!("{}", word);
    }

    // Replace a string (Use "" for deleting)

    let st2 = st1.replace("A", "Another");
    println!("{}", st2);

    // Create string of characters

    let st3 = String::from("x r t b h k k a m c");

    // Convert to a vector

    let mut v1: Vec<char> = st3.chars().collect();

    // Sort characters

    v1.sort();

    // Remove duplicates

    v1.dedup();

    // Cycle through vector

    for char in v1 {
        println!("{}", char);
    }

    // Create a string literal

    let st4: &str = "Random string";

    // Convert to heap allocated String

    let mut st5: String = st4.to_string();
    println!("{}", st5);

    // Convert string into an array of bytes

    let _byte_arr1 = st5.as_bytes(); // note the "_" which means we don't use it elsewhere

    // Get a slice of a string from index 0 to 5 — a "window" on a string

    let st6 = &st5[0..6]; // exclusive range 0 to 5
    println!("{}", st6);

    // Get length of string

    println!("String Length : {}", st6.len());

    // Delete values in a string if mutable

    st5.clear();

    // Combine strings

    let st6 = String::from("Just some");
    let st7 = String::from("words");

    // You can only add a reference to a string to another

    let st8 = st6 + &st7; // Remember the earlier example on Generics

    // Cycle through letters in a string and print unicode

    for char in st8.bytes() {
        println!("{}", char);
    }

    // Cycle through letters in a string and print characters

    for char in st8.chars() {
        println!("{}", char);
    }

    // ----- CASTING WITH "AS" -----
    // You can convert to different types in multiple ways (type coercion)

    let int_u8: u8 = 5;
    let int2_u8: u8 = 4;

    // Cast using "as"

    let _int3_u32: u32 = (int_u8 as u32) + (int2_u8 as u32); // Note the "_"

    
    // ----- VECTORS -----
    // Vectors are like arrays that can grow if mutable
    // They only store values of the same type

    // Create an empty vector with i32

    let _vec1: Vec<i32> = Vec::new();

    // Create a vector with defined values

    let mut vec2 = vec![1, 2, 3, 4];

    // Add values to the end of a vector

    vec2.push(5);

    // Get value by index

    println!("1st : {}", vec2[0]);

    // Verify value exists

    let _second: &i32 = &vec2[1];
    match vec2.get(1) {
        Some(second) => println!("2nd : {}", second),
        None => println!("No 2nd value"),
    };

    // Cycle and change values

    for i in &mut vec2 {
        *i *= 2; // the "*i" dereferences i to update the contents of the item pointed to.
    }

    // Cycle through vector values

    for i in &vec2 {
        println!("{}", i);
    }

    // Get number of values in a vector

    println!("Vec Length : {}", vec2.len());

    // Remove and return the last value

    println!("Pop {:?}", vec2.pop());
}
