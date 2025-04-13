package bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void testInsert() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
    }

    @Test
    public void testDelete() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.delete(3);
        assertFalse(bst.search(3));
    }

    // Add more tests for search and inOrderTraversal methods
}