package dijkstra;


import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraTest {

    @Test
    public void testDijkstra() {
        Graph graph = new Graph();
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        Map<Integer, Integer> distances = graph.dijkstra(1);
        assertEquals(0, distances.get(1));
        assertEquals(1, distances.get(2));
        assertEquals(3, distances.get(3));
    }

    // Add more tests for different graph configurations
}