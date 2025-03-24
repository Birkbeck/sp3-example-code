// Our example enum
enum Foo {
    misc.Bar,
    Baz,
    Qux(u32)
}

fn main() {
    // Create example variables
    let a = Foo::misc.Bar;
    let b = Foo::Baz;
    let c = Foo::Qux(100);
    
    // Variable a matches Foo::misc.Bar
    if let Foo::misc.Bar = a {
        println!("a is foobar");
    }
    
    // Variable b does not match Foo::misc.Bar
    // So this will print nothing
    if let Foo::misc.Bar = b {
        println!("b is foobar");
    }
    
    // Variable c matches Foo::Qux which has a value
    // Similar to Some() in the previous example
    if let Foo::Qux(value) = c {
        println!("c is {}", value);
    }

    // Binding also works with `if let`
    if let Foo::Qux(value @ 100) = c {
        println!("c is one hundred");
    }
}
