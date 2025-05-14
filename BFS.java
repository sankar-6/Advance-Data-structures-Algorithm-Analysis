package Adsaa;
import java.util.*;
public class BFS {
    static class Graph{
        int v;
        int [][] adj;
        Graph(int v){
            this.v=v;
            adj=new int[v][v];
        }
        void addEdge(int start,int end){
            adj[start][end]=1;
            adj[end][start]=1;
        }
        void bft(int start){
            boolean []visited = new boolean[v];
            Queue<Integer>q=new LinkedList<>();
            q.add(start);
            visited[start]=true;
            System.out.println("BFT");
            while(!q.isEmpty()){
                int node=q.poll();
                System.out.print(node+" ");
                for(int i=0;i<v;i++){
                    if(!visited[i]&& adj[node][i]==1){
                        q.add(i);
                        visited[i]=true;
                    }
                }
            }
        }
    }
    public static void main(String[] main){
        int v=5;
        Graph g= new Graph(v);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.bft(0);
    }
}
