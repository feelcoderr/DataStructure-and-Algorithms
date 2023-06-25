import java.util.*;
public class PairSum2 {
    //BroutForce Approch O(n^2)
    static boolean targetSum(ArrayList<Integer> list, int tar){
        for(int i=0; i<list.size()-1; i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i)+list.get(j)==tar){
                    return true;
                }
            }
        }
        return false;
    }
    //Two Pointer Approch O(n)
    static boolean optimizedTargetSum(ArrayList<Integer> list, int tar){
        int lp=0, rp=list.size()-1;
        int n=list.size();
        for(int i=0; i<n-1; i++){
            if(list.get(i)>list.get(i+1)){
                lp=i+1;
                rp=i;
            }
        }

        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==tar){
                return true;
            }
            if(list.get(lp)+list.get(rp)>tar){// Modulo methods to itorate over array int loop of 0 to n-1
                rp=(n+rp-1)%n;
            }else{
                lp=(lp+1)%n; 
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer> list= new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(9);
        list.add(10);
        
        System.out.println(targetSum(list, 26));
        System.out.println(optimizedTargetSum(list, 26));
    }
}
