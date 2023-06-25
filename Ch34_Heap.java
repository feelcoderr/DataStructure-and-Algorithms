import java.util.*;
import java.util.Comparator;
public class Ch34_Heap {
    public static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){ //O (log n)
            //add at last place
            arr.add(data);

            //fix heap
            int child = arr.size()-1;
            int par = (child - 1) / 2;
            
            while(arr.get(child) > arr.get(par)){
                //swap 
                int temp = arr.get(child);
                arr.set(child, par);
                arr.set(par, temp);

                child = par;
                par = (child-1) / 2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = (2 * i) -1 ;
            int right = (2 * i) - 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(left) < arr.get(i)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(right) < arr.get(i)){
                minIdx = right;
            }

            if(minIdx != i){
                //swap
                int temp = arr.get(minIdx);
                arr.set(minIdx, arr.get(i));
                arr.set(i, temp);
            }
        }

        public void remove(){
            //step-1: swap first and last node
            int temp = arr.get(arr.size() - 1);
            arr.set(arr.size()-1, arr.get(0));
            arr.set(0, temp);

            //step-2: remove last Node
            arr.remove(arr.size()-1);

            //step-3: fix heap
            heapify(0);
            return;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    //Heap Sort
    public static void heapify(int arr[], int i, int size){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            //swap
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;

            heapify(arr, maxIdx, size);
        }
    }
    public static void heapSort(int arr[]){
        //step-1 create max heap from array
        int n = arr.length;
        for(int i=n/2 ; i>=0; i--){
            heapify(arr, i, n); 
        }

        //step-2 push largest at the end
        for(int i=n-1; i>0; i--){
            //swap first and last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }

    }

    //Near by Cars k cars
    static class Point implements Comparable<Point>{
        int idx;
        int x;
        int y;
        int distsq;
        public Point(int idx, int x, int y, int distsq){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.distsq = distsq;
        }

        @Override
        public int compareTo(Point p2){
            return this.distsq - p2.distsq;
        }
    }
    public static void nearestKCars(int pts[][], int k){
        PriorityQueue<Point> pq= new PriorityQueue<>();
        int distsq;
        for(int i=0; i<pts.length; i++){
            distsq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1]; // dist^2 = x^2 + y^2
            pq.add(new Point(i, pts[i][0], pts[i][1], distsq));
        }

        //near by k cars
        for(int i=0; i<k; i++){
            System.out.print("C"+ pq.remove().idx + " ");
        }

    }


    //Minimun Cost to connect n ropes
    public static int minCostToConnect(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<ropes.length; i++){
            pq.add(ropes[i]);
        }

        int min, min2, cost = 0;
        while(pq.size() > 1){
            min = pq.remove();
            min2 = pq.remove();
            cost += min+ min2;
            pq.add(min + min2);
        }
        return cost;
        
    }

    //Weakest soldiers Row 
    static class Row implements Comparable<Row>{
        int idx;
        int soldiers;
        public Row(int idx, int soldiers){
            this.idx = idx;
            this.soldiers = soldiers;
        }

        @Override
        public int compareTo(Row R2){
            if(this.soldiers == R2.soldiers){
                return this.idx - R2.idx;
            }else{
                return this.soldiers - R2.soldiers;
            }
        }
    }
    public static void weakestRow(int rows[][], int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();

        
        for(int i=0; i<rows.length; i++){
            int soldiers = 0;
            for(int j=0; j<rows[i].length; j++){
                if(rows[i][j]== 1){
                    soldiers++;
                }
            }
            pq.add(new Row(i, soldiers));
        }

        for(int i=0; i<k; i++){
            System.out.println("Row "+ pq.remove().idx);
        }
    }
    public static void main(String args[]){
        // Heap h = new Heap();

        // h.add(3);
        // h.add(1);
        // h.add(9);
        // h.add(5);

        // while(! h.isEmpty()){
        //     System.out.print(h.peek()+" ");
        //     h.remove();
        // }

        // int arr[] = {1, 2, 5, 4, 3};
        // heapSort(arr);
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i]+ " ");
        // }

        // int pts[][] = {{3,3}, {5,-1}, {-2, 4}};
        // int k = 2;
        // nearestKCars(pts, k);

        // int ropes[] = {2, 3, 3, 4, 6};
        // System.out.println("Min Cost is : " + minCostToConnect(ropes));

        int army[][] = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}};

        int k=2;
        weakestRow(army, k);
    }
}
