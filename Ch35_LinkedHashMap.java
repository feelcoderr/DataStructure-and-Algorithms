import java.util.*;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.TreeMap;

public class Ch35_LinkedHashMap {

    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 100);
        hm.put("US", 50);

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 150);
        lhm.put("China", 100);
        lhm.put("US", 50);

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 150);
        tm.put("China", 100);
        tm.put("US", 50);

        System.out.println(hm); //unordered
        System.out.println(lhm); //it will print data in insertion order
        System.out.println(tm); //it will print data in ordered by key
    }
}
