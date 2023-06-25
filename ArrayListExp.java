import java.util.ArrayList;
import java.util.Collections;
public class ArrayListExp {

    
    static void reversePrint(Integer list){
        
    }
    public static void main(String args[]){
        ArrayList<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(30);
        list.add(4);
        list.add(5);

        //print reverse arraylist
        // for(int i=list.size()-1; i>=0; i--){
        //     System.out.print(list.get(i));
        // }

        //Maximum of arraylis
        // int max=Integer.MIN_VALUE;
        // for(int i=0; i<list.size(); i++){
        //     max=Math.max(max, list.get(i));
        // }
        // System.out.println(max);

        //Swap two element
        // int Idx1=2, Idx2=0;
        // int temp=list.get(Idx1);
        // list.set(Idx1,list.get(Idx2));
        // list.set(Idx2,temp);
        // System.out.println(list);

        //Sort arraylist
        //in ascending order
        Collections.sort(list);
        System.out.println(list);
        //in decending order
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
}
