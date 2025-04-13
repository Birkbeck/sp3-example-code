# Data Structures and Algorithms Worksheet

These questions are designed to examine your understanding of the above topic in `Java`. The skeleton code is provided in the source code tree together with some `JUnit` 5 tests.

Questions marked with **@** and **@@** are set at a greater difficulty level.

---

### Task 1: Implementing a Linked List
**Objective:** Implement a singly linked list with basic operations.

**Instructions:**
1. Implement the `Node` class.
2. Implement the `LinkedList` class with the following methods:
   - `add(int data)`
   - `remove(int data)`
   - `contains(int data)`
   - `size()`

See the `linkedlist` package(s) for skeleton code and tests.

### Task 2: Implementing a Binary Search Tree
**Objective:** Implement a binary search tree (BST) with basic operations.

**Instructions:**
1. Implement the `TreeNode` class.
2. Implement the `BinarySearchTree` class with the following methods:
   - `insert(int data)`
   - `delete(int data)`
   - `search(int data)`
   - `inOrderTraversal()`


See the `bst` package(s) for skeleton code and tests.

### Task 3: Implementing a HashMap
**Objective:** Implement a simple HashMap with basic operations.

**Instructions:**
1. Implement the `HashMap` class with the following methods:
   - `put(K key, V value)`
   - `get(K key)`
   - `remove(K key)`
   - `containsKey(K key)`

See the `hashmap` package(s) for skeleton code and tests.

### Task 4: Implementing a Stack
**Objective:** Implement a stack using an array.

**Instructions:**
1. Implement the `Stack` class with the following methods:
   - `push(int data)`
   - `pop()`
   - `peek()`
   - `isEmpty()`


See the `stack` package(s) for skeleton code and tests.

### Task 5: Implementing a Queue
**Objective:** Implement a queue using a linked list.

**Instructions:**
1. Implement the `Queue` class with the following methods:
   - `enqueue(int data)`
   - `dequeue()`
   - `peek()`
   - `isEmpty()`

See the `queue` package(s) for skeleton code and tests.

### Task 6: Implementing a Priority Queue **@**
**Objective:** Implement a priority queue using a binary heap.

**Instructions:**
1. Implement the `PriorityQueue` class with the following methods:
   - `insert(int data)`
   - `extractMin()`
   - `peekMin()`

See the `priorityqueue` package(s) for skeleton code and tests.

### Task 7: Implementing a Graph (Adjacency List) **@@**
**Objective:** Implement a graph using an adjacency list and perform BFS and DFS.

**Instructions:**
1. Implement the `Graph` class with the following methods:
   - `addEdge(int src, int dest)`
   - `bfs(int start)`
   - `dfs(int start)`

See the `graphadjacencylist` package(s) for skeleton code and tests.

### Task 8: Implementing Dijkstra's Algorithm **@@**
**Objective:** Implement Dijkstra's algorithm for finding the shortest path in a weighted graph.

**Instructions:**
1. Implement the `Graph` class with the following methods:
   - `addEdge(int src, int dest, int weight)`
   - `dijkstra(int start)`

See the `dijkstra` package(s) for skeleton code and tests.

---
End of worksheet
