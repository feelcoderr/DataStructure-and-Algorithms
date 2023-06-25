import java.util.Arrays;
import java.util.Collections;

public class Sorting {

    //Bubble sort
    public static void bubbleSort (int arr[]){
        for(int turn=0; turn<arr.length-1; turn++){
            int swaps=0;
            for(int j=0; j<arr.length-1-turn; j++){
                if(arr[j]>arr[j+1]){
                    swaps++;
                    int temp= arr[j+1];
                    arr[j+1]= arr[j];
                    arr[j]= temp;
                }
            }
            if(swaps==0){
                return;
            }
        }
        return;
    }

    //Selection Sort

    public static void selectionSort (int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minPos = i;
            for(int j=i+1; j<arr.length; j++ ){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            //Swap
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
        return;
    }

    //Insertion sort
    public static void insertionSort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int curr=arr[i];
            int prev=i-1;
            //finding out the correct position for insert
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]= arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1]=curr;
        }
    }

    //Counting sort
    public static void countingSort(int arr[]){
        int largest= Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest= Math.max(arr[i], largest);
        }

        int count[] = new int[largest+1];
        for(int j=0; j<arr.length; j++){
            count[arr[j]]++;
        }

        //sorting
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }

    // Array Printing
    public static void PrintArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        return;
    }
    public static void main(String [] args){
        int numbers[]= {5,3,1,2,4};

        //bubbleSort(numbers);
        //selectionSort(numbers);
        //insertionSort(numbers);

        //inbuilt sort
        //Arrays.sort(numbers);
        //Arrays.sort(numbers,3,5);
        //reverse
        //Arrays.sort(numbers,Collections.reverseOrder());
        //Arrays.sort(numbers,3,5,Collections.reverseOrder());

        countingSort(numbers);
        PrintArr(numbers);

        return;
    }
}