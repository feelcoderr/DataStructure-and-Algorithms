//import pekage for use Arraylist
import java.util.ArrayList;

public class ArrrayList {
    public static void main(String args[]){
        ArrayList<Integer> nums = new ArrayList<>();
        
        // to add something in arraylist
        nums.add(2);
        nums.add(3);
        nums.add(6);
        nums.add(2);
        nums.add(9);
        System.out.println(nums);

        //to add any index
        //nums.add(3,0);

        //to get element from array list
        // int element= nums.get(2);
        // System.out.println(element);

        //remove element
        // nums.remove(1);
        // System.out.println(nums);

        //change or set element
        // nums.set(1, 30);
        // System.out.println(nums);

        //check element contains
        // System.out.println(nums.contains(9));
        // System.out.println(nums.contains(4));

        //to get size of array list
        System.out.println(nums.size());
        //iterate in array list
        for(int i=0; i<nums.size(); i++){
            System.out.print(nums.get(i));
        }
        System.out.println();
    }
}
