public class MergeSort {
    //Print Arrays
    static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    //Merge sort
    static void mergeSort(int arr[], int si, int ei){
        //Base case
        if(si>=ei){
            return;
        }
        //Kaam
        int mid=si+(ei-si)/2;//which is equal to (si+ei)/2
        mergeSort(arr, si, mid);//for left side array
        mergeSort(arr,mid+1,ei);//for right side array
        merge(arr,si,mid,ei);
    }
    //to merge sorted arrays
    static void merge(int arr[], int si, int mid, int ei){
        //make temp array to store sorted array
        int temp[] = new int [ei-si+1];
        int i=si; // itorator for left part
        int j=mid+1;//itorator for right part
        int k=0; //itorator for temp

        //for compare and merge to sorted array
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        //if left elements remain
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //if right elements remain
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //Copy temp array in original array
        for(k=0,i=si; k<temp.length; k++,i++){
            arr[i]=temp[k];
            //System.out.print(temp[k]);
        }
    }
    public static void main(String args[]){
        int arr[]= {6,3,9,5,2,8,4};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}

