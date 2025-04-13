package graphadjacencylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GraphTest {

    @Test
    public void testAddEdge() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        assertTrue(graph.getAdjList().get(1).contains(2));
        assertTrue(graph.getAdjList().get(2).contains(3));
    }

    @Test
    public void testBFS() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        List<Integer> bfsResult = graph.bfs(1);
        assertEquals(Arrays.asList(1, 2, 3), bfsResult);
    }

    // Add more tests for dfs method
}