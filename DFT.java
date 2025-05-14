package Adsaa;

public class DFT {
    static class Graph{
        int v;
        int adj [][];
        Graph(int v){
            this.v=v;
            adj=new int[v][v];
        }
        void addEdge(int start,int end){
            adj[start][end]=1;
            adj[end][start]=1;
        }
        void dft(){
            boolean [] visited= new boolean[v];
            System.out.println("DFT is :");
            for(int i=0;i<v;i++){
                if(!visited[i]){
                    dfs(i,visited);
                }
            }
        }
        void dfs(int node,boolean[]visited){
            visited[node]=true;
            System.out.print(node+" ");
            for(int i=0;i<v;i++){
                if(!visited[i]&& adj[node][i]==1){
                    dfs(i,visited);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v=5;
        Graph g = new Graph(v);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1,4);
        g.dft();
    }
}
