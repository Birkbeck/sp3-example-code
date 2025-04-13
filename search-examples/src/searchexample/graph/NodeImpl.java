package searchexample.graph;

public class NodeImpl implements Node {
    private char label;
    private boolean visited;

    public NodeImpl(final char label) {
        this.setLabel(label);
    }

    @Override
    public char getLabel() {
        return label;
    }

    @Override
    public void setLabel(final char label) {
        this.label = label;
    }

    @Override
    public boolean isVisited() {
        return visited;
    }

    @Override
    public void setVisited(final boolean visited) {
        this.visited = visited;
    }
}
