
import java.util.Comparator;
import java.util.PriorityQueue;
public class Ch34_PriorityQueue {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }

    //Sliding window maximum
    static class Pair implements Comparable<Pair>{
        int idx;
        int val;

        public Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair p2){
            //descending order
            return p2.val - this.val;
        }
    }
    public static void slidingWindowMax(int arr[], int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int res[] = new int[arr.length - k + 1];
        //add 1st window
        for(int i=0; i<k; i++){
            pq.add(new Pair(i, arr[i]));
        }

        res[0] = pq.peek().val;
        
        //remove top until it is not in window idx
        for(int i=k; i<arr.length; i++){
            while(pq.size()>0 && pq.peek().idx <= i - k){
                pq.remove();
            }

            pq.add(new Pair(i, arr[i]));
            res[i - k + 1] = pq.peek().val;
        }

        //print result
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
    public static void main(String args[]){
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("a", 3)); // O(log n)
        pq.add(new Student("b", 9));
        pq.add(new Student("c", 20));
        pq.add(new Student("d", 2));
        pq.add(new Student("e", 5));
        pq.add(new Student("f", 12));

        // while(!pq.isEmpty()){
        //     System.out.print(pq.peek().name + "-> " + pq.peek().rank); // O(1)
        //     pq.remove(); // O(log n)
        // }

        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;
        slidingWindowMax(arr, k);
    }
}
