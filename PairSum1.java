import java.util.*;
public class PairSum1 {
    //Bruteforce approch O(n^2)
    static boolean targetSum(ArrayList<Integer> list, int tar){
        for( int i=0; i<list.size()-1; i++){
            for(int j=i+1; j<list.size(); j++){
                int sum= list.get(i)+list.get(j);
                if(sum==tar){
                    System.out.println(i+", "+j);
                    return true;
                }
            }
        }
        System.out.println("Pair not available");
        return false;
    }
    //Two pointer Approch O(n)
    static boolean optimizedTargetSum(ArrayList<Integer> list, int tar){
        Integer lp=0, rp=list.size()-1;

        while(lp<rp){
            if(list.get(lp)+list.get(rp)==tar) return true;

            if(list.get(lp)+list.get(rp)<tar){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer> list= new ArrayList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        targetSum(list, 60);
        System.out.println(optimizedTargetSum(list, 60));
        
    }
}
