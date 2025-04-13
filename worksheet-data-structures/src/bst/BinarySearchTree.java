package bst;

import lombok.Data;

@Data
public class BinarySearchTree {
    private TreeNode root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.data()) {
            root.left(insertRec(root.left(), data));
        } else if (data > root.data()) {
            root.right(insertRec(root.right(), data));
        }
        return root;
    }

    // Implement delete, search, and inOrderTraversal methods
}