import java.util.*;
public class ListOfArrayList {
    public static void main(String args[]){

        ArrayList <ArrayList<Integer>> mainlist= new ArrayList<>(); // List of Arraylist

        ArrayList<Integer> list1= new ArrayList<>();//this is Arraylist
        ArrayList<Integer> list2= new ArrayList<>();//this is Arraylist

        //add values in arraylists
        list1.add(1);
        list1.add(2);
        list2.add(3);
        list2.add(4);

        //add arrayLists in list of ArrayList(mainlist)
        mainlist.add(list1);
        mainlist.add(list2);

        for(int i=0; i<mainlist.size(); i++) {
            for(int j=0; j<list1.size(); j++){
                System.out.print(mainlist.get(i).get(j));
            }
            System.out.println();
        }
    }
}
