import java.util.*;
public class FindItinerary {
    public static String getStarting(HashMap<String, String> tickets){
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
    public static void main(String args[]){
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("channai","bangluru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "channai");
        tickets.put("delhi","goa");

        String start = getStarting(tickets);
        System.out.print(start);
        for(String key: tickets.keySet()){
            System.out.print(" -> "+ tickets.get(start));
            start = tickets.get(start);
        }

    }
}
