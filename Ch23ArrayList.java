import java.util.ArrayList;
import java.util.Collections;
public class Ch23ArrayList {
    //Q-1 list is monotonic or not
    static boolean isMonotonic(ArrayList<Integer> arr){
        if(arr.get(0)<arr.get(arr.size()-1)){
            for(int i=0; i<arr.size()-1; i++){
                if(arr.get(i)>arr.get(i+1))
                return false;
            }
        }else{
            for(int i=0; i<arr.size()-1; i++){
                if(arr.get(i)<arr.get(i+1))
                return false;
            }
        }
        return true;
    }

    //Q-2 return lonely numbers from list
    //number is lonely if array dont have numers n+1 and n-1
    static ArrayList<Integer> getLonlyNums(ArrayList<Integer> arr){
        ArrayList<Integer> ln= new ArrayList<>();

        Collections.sort(arr);
        if(arr.get(0)+1!=arr.get(1)&&arr.get(0)-1!=arr.get(1))
        ln.add(arr.get(0));
        if(arr.get(arr.size()-1)+1!=arr.get(arr.size()-2)&&arr.get(arr.size()-1)-1!=arr.get(arr.size()-2))
        ln.add(arr.get(arr.size()-1));

        for(int i=1; i<arr.size()-1; i++){
            if(arr.get(i)+1!=arr.get(i-1)&&arr.get(i)-1!=arr.get(i-1) && arr.get(i)+1!=arr.get(i+1)&&arr.get(i)-1!=arr.get(i+1))
            ln.add(arr.get(i));
        }
        return ln;
    }
    static void printAL(ArrayList<Integer> arr){
        if(arr.size()==0)System.out.println("its empty");
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i) +" ");
        }

    }

    //Q-3 Most Frequent number following the key
    // static int frequentNum(ArrayList<Integer> arr, int key){
    //     ArrayList<Integer> count= new ArrayList<>();

    //     for(int i=0; i<arr.size()-1; i++){
            
    //     }
        
    // }
    public static void main(String args[]){
        ArrayList<Integer> arr= new ArrayList<>();
        // arr.add(12);
        // arr.add(8);
        // arr.add(3);
        // arr.add(1);
        // System.out.println(isMonotonic(arr));

        ArrayList<Integer> ln= new ArrayList<>();
        arr.add(10);
        arr.add(4);
        arr.add(5);
        arr.add(9);
        ln=getLonlyNums(arr);
        printAL(ln);
    }
}
