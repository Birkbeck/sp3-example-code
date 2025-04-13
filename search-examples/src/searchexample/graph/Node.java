package searchexample.graph;

public interface Node {
    char getLabel();

    void setLabel(char label);

    boolean isVisited();

    void setVisited(boolean visited);
}