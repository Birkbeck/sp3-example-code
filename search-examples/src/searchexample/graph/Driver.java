package searchexample.graph;

public class Driver {

    public static void main(final String[] args) {

        //Lets create nodes
        Node nodeA = new NodeImpl('A');
        Node nodeB = new NodeImpl('B');
        Node nodeC = new NodeImpl('C');
        Node nodeD = new NodeImpl('D');
        Node nodeE = new NodeImpl('E');
        Node nodeF = new NodeImpl('F');

        //Create the graph, add nodes, create edges between nodes
        Graph graph = new GraphImpl();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.setRootNode(nodeA);

        graph.connectNode(nodeA, nodeB);
        graph.connectNode(nodeA, nodeC);
        graph.connectNode(nodeA, nodeD);

        graph.connectNode(nodeB, nodeE);
        graph.connectNode(nodeB, nodeF);
        graph.connectNode(nodeC, nodeF);


        //Perform the traversal of the graph
        System.out.println("DFS Traversal of a tree is ------------->");
        graph.dfs();
        System.out.println();

        System.out.println("BFS Traversal of a tree is ------------->");
        graph.bfs();
    }
}
