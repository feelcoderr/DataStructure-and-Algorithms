public class ArrayBackTracking {
    static void changeArr(int arr[], int i, int val){
        //Base case
        if(i==arr.length){
            printArr(arr);
            return ;
        }
        //Recursion
        arr[i]=val;
        changeArr(arr, i+1, val+1);    //Recursion
        arr[i]-=2;                     //BackTracking
    }
    static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[]= new int[5];
        int val=1, i=0;
        changeArr(arr, i, val);
        printArr(arr);
    }
}
