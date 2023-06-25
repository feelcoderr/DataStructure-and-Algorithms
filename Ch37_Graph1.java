import java.util.*;
import java.util.LinkedList;

public class Ch37_Graph1 {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }
    public static void bfs(ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]){
        //mark curr visited
        System.out.print(curr);
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }

    //has path from sourse to destination
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]){
        //source is destination
        if(src == dest) return true;

        //check that neighbors have path
        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i); 
            //e.dest is neighbors
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        /* --> Graph

                   5
             (0)-------(1)
                    1 /  \ 3
                     /    \ 
                   (2)----(3)
                  2 |   1
                    |
                   (4)
         */

         int v = 5;

         //int arr[] = new int[];
         ArrayList<Edge>[] graph = new ArrayList[v];
        
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        //vertex 0
        graph[0].add(new Edge(0, 1, 5));//(sourse, destination, weight)

        //vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //vertex 4
        graph[4].add(new Edge(4, 2, 2));


        //2's neighbors
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");// neighbors is destination
            System.out.println();
        }

        //bfs(graph);

        boolean vis[] = new boolean[graph.length];
        //dfs(graph, 0, vis);

        System.out.println(hasPath(graph, 0, 6, vis));
    }
}
