import java.util.*;
public class Ch35_HashMap {
    //Mejority Elements
    public static void mejorityElement(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            // if(map.containsKey(arr[i])){
            //     map.put(arr[i], map.get(arr[i]) + 1);
            // }else{
            //     map.put(arr[i], 1);
            // }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //Set<Integer> keySet = map.keySet();
        for(Integer key : map.keySet()){
            if(map.get(key) > arr.length/3){
                System.out.println(key);
            }
        }
    }

    //Valid Anagrams
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)+1);
                }
            }else{
                return false;
            }
        }

        return map.isEmpty();
    }

    //Find itinery from tickets
    public static String getStarting(HashMap<String, String> tickets){//<from, to>
        //make reverseMap <to, from>
        // HashMap<String, String> revMap = new HashMap<>();
        // for(String key: tickets.keySet()){
        //     revMap.put(tickets.get(key), key);
        // }

        // for(String key: tickets.keySet()){
        //     if(!(revMap.containsKey(key))){
        //         return key; // starting point
        //     }
        // }
        // return null;

        HashMap<String, String> revMap = new HashMap<>();

        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        for(String key: tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;// starting point
            }
        }
        return null;
    }
    public static void findItinery(HashMap<String, String> tickets){
        // String start = getStarting(tickets);
        // System.out.print(start);
        // for(String key: tickets.keySet()){
        //     System.out.print(" ->"+ tickets.get(start));
        //     start = tickets.get(start);
        // }

        String start = getStarting(tickets);
        System.out.print(start);
        for(String key: tickets.keySet()){
            System.out.print(" -> "+ tickets.get(start));
            start = tickets.get(start);
        }
    }

    //Largest Subarray Sum
    public static int LargestSum(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int len = 0;

        for(int j=0; j<arr.length; j++){
            sum += arr[j];

            if(map.containsKey(sum)){
                len = Math.max(len, j-map.get(sum));
            }else{
                map.put(sum, j);
            }
        }

        return len;
    }

    //Subarrays sum equal to k
    public static int subarraySum(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();// <sum, freq>

        //first pair
        map.put(0, 1);

        int sum = 0; 
        int ans = 0;
        for(int j=0; j<arr.length; j++){
            sum+= arr[j]; // sum(j)
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
    public static void main(String args[]){
        // HashMap<String, Integer> hm = new HashMap<>();
        // //Put- O(1)
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("Canada", 30);
        // hm.put("Japan", 20);
        // hm.put("US", 50);
        // System.out.println(hm);
        
        // //Get- O(1)
        // int population = hm.get("India");
        // System.out.println(population);
        // System.out.println(hm.get("shrilanka"));

        // //Contains key- O(1)
        // System.out.println(hm.containsKey("US"));
        // System.out.println(hm.containsKey("Shrilanka"));

        // //Remove - O(1)
        // System.out.println(hm.remove("China"));
        // System.out.println(hm);

        // //Size
        // System.out.println(hm.size());

        // //isEmpty
        // // System.out.println(hm.isEmpty());
        // // hm.clear();
        // // System.out.println(hm.isEmpty());

        // //iterate
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for (String k : keys) {//for each loop
        //     System.out.println("Key:"+k+", Value:"+hm.get(k));
        // }

        // int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        // mejorityElement(arr);

        // String s = "race";
        // String t = "care";
        // System.out.println(isAnagram(s, t));


        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bangaluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Channai");
        // tickets.put("Delhi", "Goa");

        // findItinery(tickets);


        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(LargestSum(arr));
        System.out.println(subarraySum(arr, 6));
    }
}
