package Datastructures;
import java.util.*;
class Graph{
    private int V,E;
    private int [][] adj;
    int count;
    class Edge{
        int u,v;
        Edge(int u,int v){
            this.u=u;
            this.v=v;
        }
    }
    Graph(int v){
        V=v;
        E=0;
        adj=new int [v][v];
    }
    void addEdge(int u,int v){
        adj[u][v]=1;
        adj[v][u]=1;
        E++;
    }
    void BCCUtil(int u,int[] low,LinkedList <Edge> st,int[] parent){
        low[u]=++count;
        int children=0;
        for(int v=0;v<V;v++){
            if(adj[u][v]==1){
                if(low[v]==-1){
                    children++;
                    parent[v]=u;
                    st.add(new Edge(u,v));
                    BCCUtil(v, low, st, parent);
                    low[u]=Math.min(low[u],low[v]);
                if(((parent[u]==-1)&&children>1)||((parent[u]!=1)&&low[v]>=low[u])){
                    while(st.getLast().u!=u||st.getLast().v!=v){
                        System.out.print(st.getLast().u+"--"+st.getLast().v+" ");
                        st.removeLast();
                    }
                    System.out.println(st.getLast().u+"--"+st.getLast().v);
                        st.removeLast();
                }
                }
                else if(v!=parent[u]){
                low[u]=Math.min(low[v],low[u]);
                st.add(new Edge(u,v));
                }
           }
        }
    }
void BCC(){
    int[] low =new int [V];
    int[] parent=new int[V];
    LinkedList<Edge>st=new LinkedList<>();
    Arrays.fill(low,-1);
    Arrays.fill(parent,-1);
    for(int i=0;i<V;i++){
        if(low[i]==-1){
            BCCUtil(i, low, st, parent);
            int j=0;
            while(!st.isEmpty()){
                j=1;
                System.out.print(st.getLast().u+"--"+st.getLast().v+" ");
                st.removeLast();
            }
            if(j==1){
                System.out.println();
            }
        }
    }
}
public static void main(String[] args) {
    Graph g= new Graph(12);
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(1,3);
    g.addEdge(2,3);
    g.addEdge(2,4);
    g.addEdge(3,4);
    g.addEdge(1,5);
    g.addEdge(0,6);
    g.addEdge(5,6);
    g.addEdge(5,7);
    g.addEdge(5,8);
    g.addEdge(7,8);
    g.addEdge(8,9);
    g.addEdge(10,11);
    g.BCC();
}
}