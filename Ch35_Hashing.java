import java.util.*;
import java.util.LinkedList;
public class Ch35_Hashing {
    static class HashMap<K,V> { //generic
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        public int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }
        public int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                bi++;
            }
            return -1;
        }

        @SuppressWarnings("uncheked")
        public void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;

            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            //nodes -> add in buckets
            for(int i=0; i<oldBuck.length; i++){
                LinkedList <Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){ //O(lamda) -> O(1)
            int bi = hashFunction(key); // bucket index
            int di = searchInLL(key, bi); // return valid idx or -1

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lamda = (double)n/N;
            if(lamda > 2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){ //O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            
            if(di != -1){
                return true;
            }else{
                return false;
            }
        }
        public V remove(K key){ //O(1)
            int bi = hashFunction(key); // bucket index
            int di = searchInLL(key, bi); // return valid idx or -1

            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }
        public V get(K key){ //O(1)
            int bi = hashFunction(key); // bucket index
            int di = searchInLL(key, bi); // return valid idx or -1

            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("nepal", 15);
        hm.put("US", 60);

        ArrayList<String> keys = hm.keySet();
        for(String key: keys){
            System.out.println(key);
        }

    }
}
