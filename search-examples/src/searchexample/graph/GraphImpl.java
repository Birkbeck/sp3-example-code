package searchexample.graph;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


public class GraphImpl implements Graph {
    private final List<Node> nodes = new ArrayList<>();
    private final Map<Node, List<Node>> adjMap = new ConcurrentHashMap();
    private Node rootNode;

    @Override
    public Node getRootNode() {
        return this.rootNode;
    }

    @Override
    public void setRootNode(final Node node) {
        this.rootNode = node;
    }

    @Override
    public void addNode(final Node node) {
        nodes.add(node);
    }

    //This method connects two nodes
    @Override
    public void connectNode(final Node start, final Node end) {
        List<Node> nodeList = adjMap.get(start);
        if (nodeList == null) {
            nodeList = new ArrayList<>();
        }
        adjMap.put(start, nodeList);
        nodeList.add(end);
    }

    private Node getUnvisitedChildNode(final Node node) {
        final List<Node> nodeList = adjMap.get(node);
        if (nodeList != null) {
            for (int i = 0; i < nodeList.size(); i++) {
                final Node temp = nodeList.get(i);
                if (!temp.isVisited()) {
                    return temp;
                }
            }
        }
        return null;
    }

    //BFS traversal of a tree
    @Override
    public void bfs() {
        //BFS uses Queue data structure
        final Queue<Node> queue = new LinkedList<>();
        queue.add(this.rootNode);
        rootNode.setVisited(true);
        printNode(this.rootNode);

        while (!queue.isEmpty()) {
            final Node node = queue.remove();
            Node child = getUnvisitedChildNode(node);
            while (child != null) {
                child.setVisited(true);
                printNode(child);
                queue.add(child);
                child = getUnvisitedChildNode(node);
            }
        }

        //Clear visited property of nodes
        clearNodes();
    }

    //DFS traversal of a tree
    @Override
    public void dfs() {
        //DFS uses Stack data structure
        final Stack<Node> stack = new Stack<>();
        stack.push(this.rootNode);
        rootNode.setVisited(true);
        printNode(rootNode);

        while (!stack.isEmpty()) {
            final Node node = stack.peek();
            final Node child = getUnvisitedChildNode(node);
            if (child == null) {
                stack.pop();
            } else {
                child.setVisited(true);
                printNode(child);
                stack.push(child);
            }
        }

        //Clear visited property of nodes
        clearNodes();
    }

    private void clearNodes() {
        for (final Entry<Node, List<Node>> eMap : adjMap.entrySet()) {
            final List<Node> list = eMap.getValue();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setVisited(false);
            }
        }
    }

    //Utility method for printing the node's label
    private void printNode(final Node node) {
        System.out.print(node.getLabel() + " ");
    }
}
