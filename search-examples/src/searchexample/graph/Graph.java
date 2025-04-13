package searchexample.graph;

public interface Graph {
    Node getRootNode();

    void setRootNode(Node node);

    void addNode(Node node);

    //This method will be called to connect two nodes
    void connectNode(Node start, Node end);

    //BFS traversal of a tree
    void bfs();

    //DFS traversal of a tree
    void dfs();
}
