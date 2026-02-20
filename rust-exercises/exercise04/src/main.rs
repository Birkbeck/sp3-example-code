// Type parameters let you write one implementation that works for many concrete types.
// Trait bounds on impl blocks restrict which types are eligible while still allowing specialised methods.

use std::fmt;

// ── Generic stack ────────────────────────────────────────────────────
struct Stack<T> {
    data: Vec<T>,
}

impl<T> Stack<T> {
    fn new() -> Self {
        Stack { data: Vec::new() }
    }
    fn push(&mut self, item: T) {
        self.data.push(item);
    }
    fn pop(&mut self) -> Option<T> {
        self.data.pop()
    }
    fn peek(&self) -> Option<&T> {
        self.data.last()
    }
    fn is_empty(&self) -> bool {
        self.data.is_empty()
    }
    fn len(&self) -> usize {
        self.data.len()
    }
}

// Display only when T: Display
impl<T: fmt::Display> fmt::Display for Stack<T> {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "Stack[")?;
        for (i, item) in self.data.iter().enumerate() {
            if i > 0 {
                write!(f, ", ")?;
            }
            write!(f, "{}", item)?;
        }
        write!(f, "]")
    }
}

// ── SortableStack — extra bound on the impl, not the struct ──────────
impl<T: Ord + Clone> Stack<T> {
    fn sorted(&self) -> Vec<T> {
        let mut v = self.data.clone();
        v.sort();
        v
    }
}

// ── Generic largest ──────────────────────────────────────────────────
fn largest<T: PartialOrd>(list: &[T]) -> &T {
    let mut best = &list[0];
    for item in list.iter() {
        if item > best {
            best = item;
        }
    }
    best
}

fn main() {
    let mut s: Stack<i32> = Stack::new();
    s.push(3);
    s.push(1);
    s.push(4);
    s.push(1);
    s.push(5);
    println!("{}", s); // Stack[3, 1, 4, 1, 5]
    println!("{:?}", s.sorted()); // [1, 1, 3, 4, 5]
    println!("peek: {:?}", s.peek()); // Some(5)
    s.pop();
    println!("new length: {}", s.len());
    println!("Stack: {}", s);
    println!("Is empty?: {}", s.is_empty());

    let numbers = vec![34, 50, 25, 100, 65];
    println!("length : {}", numbers.len());
    println!("largest: {}", largest(&numbers)); // 100
}

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn push_pop() {
        let mut s: Stack<i32> = Stack::new();
        assert!(s.is_empty());
        s.push(1);
        s.push(2);
        assert_eq!(s.len(), 2);
        assert_eq!(s.pop(), Some(2));
        assert_eq!(s.pop(), Some(1));
        assert_eq!(s.pop(), None);
    }
    #[test]
    fn sorted_returns_ordered_clone() {
        let mut s: Stack<i32> = Stack::new();
        s.push(3);
        s.push(1);
        s.push(2);
        assert_eq!(s.sorted(), vec![1, 2, 3]);
        assert_eq!(s.len(), 3); // original unchanged
    }
    #[test]
    fn largest_finds_max() {
        assert_eq!(*largest(&[1, 9, 3, 7]), 9);
    }
}
