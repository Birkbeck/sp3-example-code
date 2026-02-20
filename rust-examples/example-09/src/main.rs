// Some Maths examples

use rand::RngExt; // reference a "crate" (library)

// Note the change in the Cargo.toml file to add the "dependency" on the library

fn main() {
    // f32 has 6 digits of precision

    let num_1: f32 = 1.111111111111111;
    println!("f32 : {}", num_1 + 0.111111111111111);

    // f64 has 14 digits of precision

    let num_2: f64 = 1.111111111111111;
    println!("f64 : {}", num_2 + 0.111111111111111);

    // Basic math operators

    let num_3: u32 = 5;
    let num_4: u32 = 4;
    println!("5 + 4 = {}", num_3 + num_4);
    println!("5 - 4 = {}", num_3 - num_4);
    println!("5 * 4 = {}", num_3 * num_4);
    println!("5 / 4 = {}", num_3 / num_4);
    println!("5 % 4 = {}", num_3 % num_4); // Remainder

    // You can use var+= 1 instead of var = var + 1

    // Generate random values between 1 and 100

    let random_num = rand::rng().random_range(1..101);
    println!("Random : {}", random_num);
}
