import java.util.*;
public class Ch35_HashSet {
    //Count Distinct elements
    public static int countDistinct(int arr[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }

        return set.size();
    }

    //Union (total unique elements) 
    public static int union(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        return set.size();
    }
    //Intersection (total common elements)
    public static int intersection(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        int count=0;
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            if(set.isEmpty()){
                return count;
            }
            if(set.contains(arr2[i])){
                set.remove(arr2[i]);
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
        // HashSet<Integer> hs = new HashSet<>(); // it only contains uniqe values

        // hs.add(1);
        // hs.add(2);
        // hs.add(4);
        // hs.add(1);
        // hs.add(4);
        // hs.add(null);
        // hs.add(null);

        // System.out.println(hs);
        // System.out.println(hs.contains(2));
        
        // hs.remove(1);
        // System.out.println(hs);
        // System.out.println(hs.size());

        // HashSet<String> cities = new HashSet<>();
        // cities.add("Hydrabad");
        // cities.add("Banglour");
        // cities.add("Dilhi");
        // cities.add("Mumbai");
        // System.out.println(cities);

        // //Iteration techniqes in hashset
        // // 1)

        // // Iterator it = cities.iterator();

        // // while(it.hasNext()){
        // //     System.out.print(it.next()+" ");
        // // }

        // // 2)
        // // for(String city : cities){
        // //     System.out.println(city);
        // // }


        // //Linked HashSet - it store data in oreder
        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("Hydrabad");
        // lhs.add("Banglour");
        // lhs.add("Dilhi");
        // lhs.add("Mumbai");

        // System.out.println(lhs);

        // //Tree set - it return data in ascending order
        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("Hydrabad");
        // ts.add("Banglour");
        // ts.add("Dilhi");
        // ts.add("Mumbai");

        // System.out.println(ts);


        // int arr[] = {4, 3, 2, 5, 6, 7, 4, 3, 2};
        // System.out.println(countDistinct(arr));

        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        System.out.println(union(arr1, arr2));
        System.out.println(intersection(arr1, arr2));
    }
}
