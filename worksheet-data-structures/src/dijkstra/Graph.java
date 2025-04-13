package dijkstra;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Graph {
    private Map<Integer, List<Edge>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
        adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Edge(src, weight));
    }

    public Map<Integer, Integer> dijkstra(int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));
        distances.put(start, 0);

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.dest;

            for (Edge edge : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                int newDist = distances.get(currentNode) + edge.weight;
                if (newDist < distances.getOrDefault(edge.dest, Integer.MAX_VALUE)) {
                    distances.put(edge.dest, newDist);
                    pq.add(new Edge(edge.dest, newDist));
                }
            }
        }
        return distances;
    }

    private class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}