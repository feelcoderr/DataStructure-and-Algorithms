import java.util.*;
import java.util.LinkedList;
public class Ch26_Assignment {
    //Q-2 Connect N ropes with minimum cost
    static int minimumCost(int ropes[]){
        Arrays.sort(ropes);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<ropes.length; i++){
            q.add(ropes[i]);
        }
        int cost = 0;
        int length = 0;
        while(!q.isEmpty()){
            int l1 = length;
            int l2 = q.remove();
            length = l1 + l2;
            cost = (l1 + l2) + cost;
        }
        return cost;
    }
    public static void main(String args[]){
        int ropes[] = {4, 3, 2, 6};
        System.out.println(minimumCost(ropes));
    }
}
