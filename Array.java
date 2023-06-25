import java.util.*;

public class Array {

    //array update
    public static void update(int marks[]){
        //
        for(int i=0; i<marks.length; i++){
            marks[i]= marks[i]+2;
        }
    }

    //array Linear Search
    public static int LinearSearch(int numbers[],int key){
        

        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static void maxNumber(int numbers[]){
        //compare with largest
        int largest= Integer.MIN_VALUE;

        for(int i=0; i<numbers.length; i++){
            if(numbers[i]>largest){
                largest=numbers[i];
            }
        }
        System.out.println(largest);
    }

    //arrays Binary Search
    public static void binarySeach(int numbers[], int key){
        int start= 0, end= numbers.length-1;

        while(start<=end){
            int mid=(start+end)/2;

            //comparision
            if(numbers[mid]==key){
                System.out.println(mid);
                return;
            }
            if(numbers[mid]<key){//Right side
                start=mid+1;
            }else{//left side
                end=mid-1;
            }
            
        }
        System.out.println(-1);
        return;

    }

    //Reverse Array

    public static void reverseArray(int reverse[]){
        int first=0, last=reverse.length-1;

        while(first<last){
            int temp;
            temp=reverse[first];
            reverse[first]=reverse[last];
            reverse[last]=temp;

            first++;
            last--;
        }
        
        return;
    }

    //Posible Pairs of Numbers in Array

    public static void pairsOfNumbers(int numbers[]){
        
        for(int i=0; i<numbers.length; i++){
            int current=i;
            for(int j=i+1; j<numbers.length; j++){
                System.out.print("("+ numbers[current]+ ","+ numbers[j]+ ")");
            }
            System.out.println();
        }
    }

    //SubArrays 

    public static void subArrays(int numbers[]){
        int count=0;
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(numbers[k]+" ");
                }
                count++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Number of subarrays is :" + count);
    }

    //Max sum of SubArrays 

    public static void maxSumOfSubArrays(int numbers[]){
        int maxSum=Integer.MIN_VALUE;

        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                int sum=0;
                for(int k=i; k<=j; k++){
                    sum=sum+numbers[k];
                }
                if(sum>maxSum){
                    maxSum=sum;
                }
            }
        }
        System.out.println("Max sum of subarrays is :" + maxSum);
    }

    //Minimum sum of SubArrays

    public static void minSumOfSubArrays(int numbers[]){
        int minSum=Integer.MAX_VALUE;

        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                int sum=0;
                for(int k=i; k<=j; k++){
                    sum=sum+numbers[k];
                }
                if(sum<minSum){
                    minSum=sum;
                }
            }
        }
        System.out.println("Min sum of subarrays is :" + minSum);
    }

    //Max sum of SubArrays by Prifix method

    public static void prifixOfSubArrays(int numbers[]){
        int maxSum=Integer.MIN_VALUE;
        int sum=0;

        int prifix[]= new int[numbers.length];

        //prifix array calculation 

        prifix[0]=numbers[0];
        for(int i=1; i<numbers.length; i++){
            prifix[i]= prifix[i-1]+numbers[i];
        }

        
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
            sum=i==0?prifix[j]: prifix[j]-prifix[i-1];
            if(sum>maxSum){
                    maxSum=prifix[i];
            }
            }
        }
        System.out.println("Max sum of subarrays is :" + maxSum);
    }

    //Kadan's Algoritham for max sum of subarray

    public static void kadansAlgo(int numbers[]){
        int cs=0;
        int ms=Integer.MIN_VALUE;

        for(int i=0; i<numbers.length; i++){
            cs= cs+numbers[i];
            if(cs<0){
                cs=0;
            }

            ms= Math.max(cs,ms);
        }

        System.out.println("Maximum sum of subArrays is :"+ ms);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //creating array
        // int marks[] = {78,98,98};

        // update(marks);

        // //printing array
        // for(int i=0; i<marks.length; i++){
        //     System.out.println(marks[i]);
        // }

        //Linear Search 

        //int numbers[]={32, 34, 543, 23, 20, 02};

        //int num=LinearSearch(numbers, 2);
        //System.out.println(num);

        //Maximum of array
        //maxNumber(numbers);

        //Binary Search

        // int numbers[]= {4, 5, 34, 390, 480, 999};

        // binarySeach(numbers, 999 );

        //Reverse Array
        // int numbers[]= {4, 5, 34, 390, 480, 999};
        // reverseArray(numbers);
        // for(int i=0; i<numbers.length; i++){
        //     System.out.print(numbers[i]+" ");
        // }

        //Pairs of Numbers
        // int numbers[]= {4, 5, 34, 390, 480, 999};
        // pairsOfNumbers(numbers);

        //SubArrays

        //int numbers[]= {2, 4, 6, 8, 10};

        //subArrays(numbers);
        //maxSumOfSubArrays(numbers);
        //minSumOfSubArrays(numbers);
        //prifixOfSubArrays(numbers);

        //int numbers[]= {-4,-2,0,5,2};
        //kadansAlgo(numbers);
        char ch= 97;
        System.out.println(ch);
    }
}
