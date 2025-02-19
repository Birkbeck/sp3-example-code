package binarytree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreePrinterTest {

    private BinaryTree balanced;
    private BinaryTree leftSkewed;
    private BinaryTree rightSkewed;

    private OutputStream output;

    @BeforeEach
    public void setup() {
        balanced = createBalancedTree();
        leftSkewed = createLeftUnbalancedTree();
        rightSkewed = createRightUnbalancedTree();

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    private BinaryTree createBalancedTree() {

        BinaryTree root = new BinaryTree("root");

        BinaryTree node1 = new BinaryTree("node1");
        BinaryTree node2 = new BinaryTree("node2");
        root.setLeft(node1);
        root.setRight(node2);

        BinaryTree node3 = new BinaryTree("node3");
        BinaryTree node4 = new BinaryTree("node4");
        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(new BinaryTree("node5"));
        node2.setRight(new BinaryTree("node6"));

        BinaryTree node7 = new BinaryTree("node7");
        node3.setLeft(node7);
        node7.setLeft(new BinaryTree("node8"));
        node7.setRight(new BinaryTree("node9"));

        return root;
    }

    private BinaryTree createLeftUnbalancedTree() {

        BinaryTree root = new BinaryTree("root");

        BinaryTree node1 = new BinaryTree("node1");
        root.setLeft(node1);
        root.setRight(new BinaryTree("node2"));

        BinaryTree node3 = new BinaryTree("node3");
        node1.setLeft(node3);

        BinaryTree node4 = new BinaryTree("node4");
        node3.setLeft(node4);

        BinaryTree node5 = new BinaryTree("node5");
        node4.setLeft(node5);

        BinaryTree node6 = new BinaryTree("node6");
        node5.setLeft(node6);

        BinaryTree node7 = new BinaryTree("node7");
        node6.setLeft(node7);

        node7.setLeft(new BinaryTree("node8"));

        return root;
    }

    private BinaryTree createRightUnbalancedTree() {

        BinaryTree root = new BinaryTree("root");

        BinaryTree node2 = new BinaryTree("node2");
        root.setLeft(new BinaryTree("node1"));
        root.setRight(node2);

        BinaryTree node3 = new BinaryTree("node3");
        node2.setRight(node3);

        BinaryTree node4 = new BinaryTree("node4");
        node3.setRight(node4);

        BinaryTree node5 = new BinaryTree("node5");
        node4.setRight(node5);

        BinaryTree node6 = new BinaryTree("node6");
        node5.setRight(node6);

        BinaryTree node7 = new BinaryTree("node7");
        node6.setRight(node7);

        node7.setRight(new BinaryTree("node8"));

        return root;
    }

    @Test
    public void givenBinaryTreeBalanced_whenPrintWithBinaryTreePrinter_thenProduceCorrectOutput() {

        StringBuilder expected = new StringBuilder();
        expected.append("root").append("\n");
        expected.append("├──node1").append("\n");
        expected.append("│  ├──node3").append("\n");
        expected.append("│  │  └──node7").append("\n");
        expected.append("│  │     ├──node8").append("\n");
        expected.append("│  │     └──node9").append("\n");
        expected.append("│  └──node4").append("\n");
        expected.append("└──node2").append("\n");
        expected.append("   ├──node5").append("\n");
        expected.append("   └──node6");

        new BinaryTreePrinter(balanced).print(System.out);

        assertEquals(expected.toString(), output.toString());
    }

    @Test
    public void givenBinaryTreeLeftUnbalanced_whenPrintWithBinaryTreePrinter_thenProduceCorrectOutput() {

        StringBuilder expected = new StringBuilder();
        expected.append("root").append("\n");
        expected.append("├──node1").append("\n");
        expected.append("│  └──node3").append("\n");
        expected.append("│     └──node4").append("\n");
        expected.append("│        └──node5").append("\n");
        expected.append("│           └──node6").append("\n");
        expected.append("│              └──node7").append("\n");
        expected.append("│                 └──node8").append("\n");
        expected.append("└──node2");

        new BinaryTreePrinter(leftSkewed).print(System.out);

        assertEquals(expected.toString(), output.toString());
    }

    @Test
    public void givenBinaryTreeRightUnbalanced_whenPrintWithBinaryTreePrinter_thenProduceCorrectOutput() {

        StringBuilder expected = new StringBuilder();
        expected.append("root").append("\n");
        expected.append("├──node1").append("\n");
        expected.append("└──node2").append("\n");
        expected.append("   └──node3").append("\n");
        expected.append("      └──node4").append("\n");
        expected.append("         └──node5").append("\n");
        expected.append("            └──node6").append("\n");
        expected.append("               └──node7").append("\n");
        expected.append("                  └──node8");

        new BinaryTreePrinter(rightSkewed).print(System.out);

        assertEquals(expected.toString(), output.toString());
    }

}