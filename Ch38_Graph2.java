import java.util.*;
import java.util.LinkedList;
public class Ch38_Graph2 {
    static class Edge{
        int src;
        int dest;
        int edge;
        public Edge(int s, int d, int e){
            this.src = s;
            this.dest = d;
            this.edge = e;
        }
    }
    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                bfsUtil(graph, vis );
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[], boolean vis[]){
        Queue<Integer> q = new LinkedList<>();

        //add first node
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] != true){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                dfsUtil(graph, vis, i);
            }
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[], boolean vis[], int curr){
        //visit curr
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, vis, e.dest);
            }
        }
    }

    //Detect Cycle
    public static boolean detectCycle(ArrayList<Edge> [] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)){// i is curr vertex && dont have parent(-1)
                    return true;
                    //cycle exist in one of the parent
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par){
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){// all neighbour
            Edge e = graph[curr].get(i);
            //case 3 -not visited
            if(!vis[e.dest] && detectCycleUtil(graph, vis, e.dest, curr)){
                return true;
            }
            //case 1 -visited but not parant
            else if(!vis[e.dest] && e.dest != par){
                return true;
            }
            //case 2 -visited but parant than continue
        }
        return false;
    }

    //Is Bipartite
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int color[] = new int[graph.length];
        for(int i=0; i<color.length; i++){
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){//to check every disconected parts
            if(color[i] == -1){//bfs
                q.add(i);
                color[i] = 0; // Yellow
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        if(color[e.dest] == -1){
                            int nextCol = color[curr] == 0 ? 1: 0;// give opposite color
                            color[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if(color[e.dest] == color[curr]){
                            return false;// Not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }
    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(isCycleUtil(graph, i, vis, stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void main(String args[]){
        int v = 13;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        //connected companent 1
        graph[0].add(new Edge(0, 4, 1));

        graph[0].add(new Edge(4, 3, 1));
        graph[0].add(new Edge(4, 1, 1));
        graph[0].add(new Edge(4, 2, 1));

        graph[0].add(new Edge(3, 9, 1));

        graph[0].add(new Edge(1, 7, 1));

        //connected component 2
        graph[0].add(new Edge(6, 12, 1));
        graph[0].add(new Edge(6, 13, 1));

        graph[0].add(new Edge(12, 14, 1));
        graph[0].add(new Edge(12, 20, 1));

        //connected component 3
        graph[0].add(new Edge(25, 25, 1));

        //bfs(graph);
        //detectCycle(graph);
        System.out.println(isBipartite(graph));
    }
}
