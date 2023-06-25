public class SortedRotatedSearch {
    public static int searchTarget(int arr[], int tar, int si, int ei){
        //base case
        if(si>ei){
            return -1;
        }

        int mid=si+(ei-si)/2;//(si+ei)/2
        if(arr[mid]==tar){
            return mid;
        }

        //case 1: if mid on line 1
        if(arr[si]<=arr[mid]){
            //case a: left side of line 1
            if(arr[si]<= tar && tar <= arr[mid]){
                return searchTarget(arr, tar, si, mid-1);
            }
            //case b: right side of line 1
            else{
                return searchTarget(arr, tar, mid+1, ei);
            }
        }
        //case 2: if mid on line 2
        else{
            //case c: right side of line 2
            if(arr[mid] <= tar && tar <= arr[ei]){
                return searchTarget(arr, tar, mid+1, ei);
            }
            //case d: left side of line 2
            else{
                return searchTarget(arr, tar, si, mid-1);
            }
        }

    }
    public static void main(String args[]){
        int arr[]={4,5,6,7,0,1,2};
        int tar=4;
        int tarIdx=searchTarget(arr, tar, 0, arr.length-1);
        System.out.println(tarIdx);
    }
}
