#![warn(unused)]

fn main() {
    // ----- ITERATORS -----
    // We covered iterators before. 
    // They help us cycle through values in arrays, vectors, maps, etc.
    // An iterator cycles through values by borrowing, so the collection
    // is not moved (You can't change values)

    let arr_it = [1, 2, 3, 4];
    for val in arr_it.iter() {
        println!("{}", val);
    }

    // You can create an iterator

    let mut iter1 = arr_it.iter();

    // And call for each value with next

    println!("1st : {:?}", iter1.next());

    // You could consume a collection with
    // arr_it.into_iter() but you'll no longer be able to use the collection

    // ----- CLOSURES -----
    // A closure is a function without a name and they are sometimes stored in a variable 
    // (They can be used to pass a function into another function)

    // let var_name = |parameters| -> return_type {BODY}

    // Create a closure that defines if someone can vote

    let can_vote = |age: i32| age >= 18;
    println!("Can vote : {}", can_vote(8));

    // Closures can access variables outside of its body with borrowing

    let mut samp1 = 5;
    let print_var = || println!("samp1 = {}", samp1);
    print_var();
    samp1 = 10;

    // You can change values if you mark the closure mutable

    let mut change_var = || samp1 += 1;
    change_var();
    println!("samp1 = {}", samp1);
    samp1 = 10;
    println!("samp1 = {}", samp1);

    // You can pass closures to functions

    fn use_func<T>(a: i32, b: i32, func: T) -> i32
    where
        T: Fn(i32, i32) -> i32,
    {
        func(a, b)
    }

    let sum = |a, b| a + b;
    let prod = |a, b| a * b;

    println!("5 + 4 = {}", use_func(5, 4, sum));
    println!("5 * 4 = {}", use_func(5, 4, prod));

    // ----- SMART POINTERS -----

    // A pointer is an address to a location in memory. We have been
    // using them when we used the reference operator(&) to borrow a value.

    // Strings and vectors are smart pointers. They own
    // data and also have functions for manipulating that data.

    // Smart pointers provide functionality beyond referencing locations in memory.
    // They can be used to track who has ownership of data.
    // As you will already have seen, ownership is very important with Rust.

    // ----- BOX -----

    // The Box smart pointer stores data on the heap instead of the stack.
    // All values are stored on the stack by default

    // Stack : Stores values in a last in first out format
    // Data on the stack must have a defined fixed size

    // Heap : When putting data on the heap you request a certain amount of space.
    // The OS finds space available and returns an address for that space called a pointer.

    // A Box is normally used when you have a large amount of data stored
    // on the heap and then you pass pointers to it on the stack.

    // Create a Box with value 10

    let b_int1 = Box::new(10);

    // Get the value

    println!("b_int1 = {}", b_int1);

    // If we try to create a Binary tree we get the error the size for values of type `str` 
    // cannot be known at compilation time within `TreeNode<T>`

    // This is saying we can't include nodes in a node because the size of node depends on the 
    // size of multiple nodes which confuses the compiler

    // struct TreeNode<T> {
    //     pub left: TreeNode<T>,
    //     pub right: TreeNode<T>,
    //     pub key: T,
    // }

    // We have other problems in that Binary Trees eventually end
    // and Rust doesn't like Null values so we have to use Option

    // We can use a Box here because it has a pointer to data and a fixed size

    #[derive(Debug)] // to print it out (actually "Display" it)
    struct TreeNode<T> {
        pub left: Option<Box<TreeNode<T>>>,
        pub _key: T, // we never use this according to compiler
        pub right: Option<Box<TreeNode<T>>>,
    }

    // Create functions for creating nodes and adding left & right
    impl<T> TreeNode<T> {
        pub fn new(key_value: T) -> Self {
            TreeNode {
                left: None,
                _key: key_value,
                right: None,
            }
        }

        pub fn left(mut self, node: TreeNode<T>) -> Self {
            self.left = Some(Box::new(node));
            self
        }

        pub fn right(mut self, node: TreeNode<T>) -> Self {
            self.right = Some(Box::new(node));
            self
        }
    }

    // Create the root node with left and right

    let node1 = TreeNode::new(1)
        .left(TreeNode::new(2))
        .right(TreeNode::new(3));

    println!("The node is {:#?}", node1);
}
