package Datastructures;
import java.util.*;

class ShortPath {
    static class Edge {
        int target, weight;
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    
    public static void path(int v, List<List<Edge>> adjList, int[] dist, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[v] = 0;
        pq.offer(new int[]{v, 0});
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0], d = node[1];
            
            if (d > dist[u]) continue;
            
            for (Edge edge : adjList.get(u)) {
                int newDist = dist[u] + edge.weight;
                if (newDist < dist[edge.target]) {
                    dist[edge.target] = newDist;
                    pq.offer(new int[]{edge.target, newDist});
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        adjList.get(0).add(new Edge(1, 10));
        adjList.get(0).add(new Edge(4, 5));
        adjList.get(1).add(new Edge(0, 10));
        adjList.get(1).add(new Edge(2, 10));
        adjList.get(1).add(new Edge(3, 30));
        adjList.get(2).add(new Edge(1, 10));
        adjList.get(2).add(new Edge(3, 50));
        adjList.get(3).add(new Edge(1, 30));
        adjList.get(3).add(new Edge(2, 50));
        adjList.get(3).add(new Edge(4, 10));
        adjList.get(4).add(new Edge(0, 5));
        adjList.get(4).add(new Edge(3, 10));
        
        int[] dist = new int[n];
        
        ShortPath.path(0, adjList, dist, n);
        
        System.out.println("Shortest distances from vertex 0:");
        for (int i = 0; i < n; i++) {
            System.out.println("Distance to vertex " + i + ": " + dist[i]);
        }
    }
}
