#![allow(unused_variables)]

struct Number {
    odd: bool,
    value: i32,
}

impl Number {
    fn is_strictly_positive(self) -> bool {
        self.value > 0
    }
}

fn main() {
    let minus_two = Number {
        odd: false,
        value: -2,
    };

    println!("positive? {}", minus_two.is_strictly_positive());
    // this prints "positive? false"
}
