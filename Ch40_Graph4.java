import java.util.*;
import java.util.PriorityQueue;
public class Ch40_Graph4 {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }
    // public static void bellmenford(ArrayList<Edge> graph[], int src){
    //     int dist[] = new int[graph.length];
    //     for(int i=0; i<dist.length; i++){
    //         if(i != src){
    //             dist[i] = Integer.MAX_VALUE;
    //         }
    //     }

    //     //algo
    //     int V = graph.length;
    //     for(int i=0; i<V-1; i++){
    //         //Edge
    //         for(int j=0; j<graph.length; j++){
    //             for(int k=0; k<graph[j].size(); k++){
    //                 Edge e = graph[j].get(k);
    //                 int u = e.src;
    //                 int v = e.dest;
    //                 int wt = e.wt;
    //                 if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
    //                     dist[v] = dist[u] + wt;
    //                 }
    //             }
    //         }
    //     }
    //     //print 
    //     for(int i=0; i<dist.length; i++){
    //         System.out.print(dist[i]+" ");
    //     }
    //     System.out.println();
    // }

    //simple form
    // public static void bellmenford2(ArrayList<Edge> graph,int src, int V){
    //     int dist[] = new int[graph.size()];
    //     for(int i=0; i<dist.length; i++){
    //         if(i != src){
    //             dist[i] = Integer.MAX_VALUE;
    //         }
    //     }

    //     for(int i=0; i<V-1; i++){//O(v)
    //         for(int j=0; j<graph.size(); j++){//O(e)
    //             Edge e = graph.get(j);
    //             int u = e.src;
    //             int v = e.dest;
    //             int wt = e.wt;
    //             if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
    //                 dist[v] = dist[u] + wt;
    //             }
    //         }
    //     }
    //     //print
    //     for(int i=0; i<dist.length; i++){
    //         System.out.print(dist[i]+" ");
    //     }
    //     System.out.println();
    // }

    public static void createGraph2(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
        graph[3].add(new Edge(3, 0, 30));
    }
    public static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v, int c){
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    public static void primsAlgo(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Min cost is: "+ finalCost);
    }
    public static void main(String args[]){
        int v = 5;        
        // ArrayList<Edge> graph[] = new ArrayList[v];
        // createGraph(graph);
        //bellmenford(graph, 0);

        ArrayList<Edge> graph2[] = new ArrayList[4];
        primsAlgo(graph2);
    }
}
