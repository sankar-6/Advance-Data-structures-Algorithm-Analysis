package Adsaa;
import java.util.*;

class Graph {
    static class Pair {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private int V; // Number of vertices
    private ArrayList<ArrayList<Pair>> adjList; // Adjacency List

    // Constructor to initialize the graph
    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>()); // Initialize each vertex’s list
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Pair(v, weight)); // Add edge u -> v with weight
        adjList.get(v).add(new Pair(u, weight)); // For undirected graph: v -> u
    }

    // Dijkstra’s Algorithm to find shortest paths from the source vertex
    public void dijkstra(int start) {
        int[] dist = new int[V]; // Distance array
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int weightU = current.weight;

            if (weightU > dist[u]) continue; // Skip outdated entries

            for (Pair neighbor : adjList.get(u)) {
                int v = neighbor.node;
                int weightUV = neighbor.weight;

                if (dist[u] + weightUV < dist[v]) {
                    dist[v] = dist[u] + weightUV;
                    pq.add(new Pair(v, dist[v])); // Push updated distance
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from vertex " + start + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Distance to vertex " + i + ": " + dist[i]);
        }
    }
}

public class DijkstraAdjList {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        Graph g = new Graph(V);

        // Given adjacency matrix converted to adjacency list
        int[][] cost = {
            {0, 10, 0, 0, 5},
            {10, 0, 10, 30, 0},
            {0, 10, 0, 50, 0},
            {0, 30, 50, 0, 10},
            {5, 0, 0, 10, 0}
        };

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (cost[i][j] != 0) { // If there's an edge
                    g.addEdge(i, j, cost[i][j]);
                }
            }
        }

        int start = 0; // Fixed starting node for Dijkstra’s Algorithm
        g.dijkstra(start);
    }
}