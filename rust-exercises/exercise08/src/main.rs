// Arc<T> is an atomically reference-counted pointer.
// Mutex<T> adds interior mutability.
// Weak<T> breaks reference cycles — it does NOT prevent deallocation.
// Always call .upgrade() before using a Weak.

use std::collections::VecDeque;
use std::sync::{Arc, Mutex, Weak};

struct NodeInner<T> {
    value: T,
    children: Vec<Arc<Mutex<NodeInner<T>>>>,
    parent: Option<Weak<Mutex<NodeInner<T>>>>,
}

type Node<T> = Arc<Mutex<NodeInner<T>>>;

fn new_node<T>(value: T) -> Node<T> {
    Arc::new(Mutex::new(NodeInner {
        value,
        children: vec![],
        parent: None,
    }))
}

fn add_child<T>(parent: &Node<T>, child: &Node<T>) {
    // Give the child a weak back-reference to its parent
    child.lock().unwrap().parent = Some(Arc::downgrade(parent));
    parent.lock().unwrap().children.push(Arc::clone(child));
}

fn get_value<T: Clone>(node: &Node<T>) -> T {
    node.lock().unwrap().value.clone()
}

fn set_value<T>(node: &Node<T>, val: T) {
    node.lock().unwrap().value = val;
}

fn children_count<T>(node: &Node<T>) -> usize {
    node.lock().unwrap().children.len()
}

// Breadth-first search returning values in BFS order
fn bfs<T: Clone>(root: &Node<T>) -> Vec<T> {
    let mut result = Vec::new();
    let mut queue: VecDeque<Node<T>> = VecDeque::new();
    queue.push_back(Arc::clone(root));
    while let Some(node) = queue.pop_front() {
        let inner = node.lock().unwrap();
        result.push(inner.value.clone());
        for child in &inner.children {
            queue.push_back(Arc::clone(child));
        }
    }
    result
}

fn main() {
    let root = new_node(1);
    let c1 = new_node(2);
    let c2 = new_node(3);
    let gc1 = new_node(4); // grandchild

    add_child(&root, &c1);
    add_child(&root, &c2);
    add_child(&c1, &gc1);

    println!("Number of children: {}", children_count(&root));

    println!("BFS: {:?}", bfs(&root)); // [1, 2, 3, 4]
    set_value(&gc1, 99);
    println!("gc1 now: {}", get_value(&gc1)); // 99

    // Demonstrate Weak parent access
    let parent_weak = gc1.lock().unwrap().parent.clone().unwrap();
    if let Some(parent) = parent_weak.upgrade() {
        println!("gc1 parent value: {}", get_value(&parent)); // 2
    }

    // Show Arc clone is cheap (just increments reference count)
    let clone = Arc::clone(&root); // O(1), no data copy
    assert_eq!(get_value(&clone), 1);
}
