// ----- PACKAGES CRATES & MODULES -----
// It is very important to keep your code organized
// You can split code into multiple files
// Packages can contain multiple crates
// You can define what code is public and which is private

// Create a file called mod.rs in a directory named restaurant
// in the src directory

// Crates : Modules that produce a library or executable
// Modules : Organize and handle privacy
// Packages : Build, test and share crates
// Paths : A way of naming an item such as a struct, function

// Packages can contain 0 or 1 library crate and as many binary crates
// as you want. If you want more binary crates create a folder
// called bin (Create bin directory in src and create file in it
// named more_stuff.rs)

// Call for the public function that will allow us access to
// the module

// Declare that we want to use the restaurant module here
mod restaurant;

// Declare a specific function we'll use to access the pizza_order module

use crate::restaurant::order_food;

fn main() {
    order_food();
}
