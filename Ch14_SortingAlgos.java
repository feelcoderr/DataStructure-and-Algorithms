public class Ch14_SortingAlgos {

    //Bubble Sort
    public static void bubbleSort(int arr[]){
        for(int turns=0; turns<arr.length-1; turns++){
            int swap=0;
            for(int i=0; i<arr.length-turns-1; i++){
                if(arr[i]>arr[i+1]){
                    //swap
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;

                    swap++;
                }
            }if(swap==0)return;
        }
    
    }
    //Selection Sort
    public static void selectionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minPos=i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            //swap
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
        return;
    }

    //Incersion sort
    public static void incersionSort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int curr=arr[i];
            int prev=i-1;

            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            //incrertion
            arr[prev+1]=curr;
        }
    }

    //Counting sort
    public static void countingSort(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max=Math.max(max, arr[i]);
        }
        int count[]=new int [max+1];

        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        int idx=0;
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                arr[idx]=i;
                idx++;
                count[i]--;
            }
        }
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int arr[]={34,22,3,12,0,8};
        //bubbleSort(arr);
        //selectionSort(arr);
        //incersionSort(arr);
        countingSort(arr);
        printArr(arr);
    }
}
