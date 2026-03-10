#![allow(unused)] 

// ----- STRUCTS -----
    // A struct is a custom data type that stores multiple types of data
    // Somewhat analagous to a record

fn main() {

    struct Customer {
        _name: String, // we don't access this field
        address: String,
        balance: f32,
    }

    // Create struct

    let mut bob = Customer {
        _name: String::from("Bob Smith"), // we don't access this field
        address: String::from("555 Main St"),
        balance: 234.50,
    };

    // Change a value

    bob.address = String::from("505 Main St");
    println!("Address : {}", bob.address);

    // You could accept multiple data types using generics. 
    // If we had a rectangle struct that could accept floats or ints 
    // we would need 2 generics
    
    /* struct Rectangle<T, U> {
        length: T,
        height: U
    }
    
    The data type is defined when the struct is created

    let rec = Rectangle {length: 4, height: 10.5};
    */

    // We can tie struct properties to functions using Traits
    // You can create functions that can be used by any structs
    // that implement the right traits

    trait Shape {
        // This is a constructor which returns a Shape
        fn new(length: f32, width: f32) -> Self;

        // An area function that belongs to this trait
        fn area(&self) -> f32;
    }

    // Define rectangle and circle struct

    struct Rectangle {
        length: f32,
        width: f32,
    }
    struct Circle {
        length: f32,
        width: f32,
    }

    const PI: f32 = 3.141592;

    // Implement the trait for rectangle

    impl Shape for Rectangle {
        // Constructor
        fn new(length: f32, width: f32) -> Rectangle {
            return Rectangle { length, width };
        }

        // self allows us to refer to parameters for this struct
        fn area(&self) -> f32 {
            return self.length * self.width;
        }
    }

    // Implement the trait for circle

    impl Shape for Circle {
        // Constructor
        fn new(length: f32, width: f32) -> Circle {
            return Circle { length, width };
        }

        fn area(&self) -> f32 {
            return (self.length / 2.0).powf(2.0) * PI;
        }
    }

    // Create circle and rectangle with Shape

    let rec: Rectangle = Shape::new(10.0, 10.0);
    let circ: Circle = Shape::new(10.0, 10.0);

    println!("Rec Area : {}", rec.area());
    println!("Circ Area : {}", circ.area());

    // We can implement methods on structs using generics
    // impl<T, U>Shape<T, U> ...
}
