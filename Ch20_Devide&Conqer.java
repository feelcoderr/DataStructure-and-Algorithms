import java.util.*;
public class AssignCh20 {
    public static void mergeSort(String arr[],int si, int ei){
        //base case
        if(si>=ei){
            return ;
        }

        //kaam
        int mid= si+ (ei-si)/2;//(si+ei)/2
        String[] arr1=mergeSort(arr, si, mid);
        String[] arr2=mergeSort(arr,mid+1,ei);
        merge(arr1, arr2);
    }
    public static void merge(String arr1[], String arr2[]){
        String temp[]= new String[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int k=0;

        //comparision of both strings of right and left
        while(i<arr1.length && j<arr2.length){
            if(isAlphabeticallySmaller(arr1[i],arr2[j])){
                temp[k++]=arr[i++];
            }else {
                    temp[k++]=arr[j++];
            }  
        }

        //if left strings remain
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //if right Strings remain
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //store temp into original array
        for(int a=0,b=0; a<temp.length; a++, b++){
            arr[b]=temp[a];
        }
    }

    //Print array
    public static void printArr(String arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]){
        String arr[]={"sun", "earth", "mars", "mercury"};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
        //Logic to compare strings
        // while(i<Math.min(s.length(),k.length())){
        //     if(s.charAt(i)<k.charAt(i) || i==s.length()-1){
        //         System.out.println("Stored s");
        //         break;
        //     }else if(s.charAt(i)>k.charAt(i) || i==k.length()-1){
        //         System.out.println("Stored k");
        //         break;
        //     }else{
        //         i++;
        //     }
        // }
        
    }
}
