public class Ch19_Recursion {
    // Q-1 Find every occurence of key
    static void findKeys(int arr[], int i, int key){
        //base case
        if(i==arr.length){
            return;
        }
        //Kaam
        if(arr[i]==key){
            System.out.print(i);
        }
        //call
        findKeys(arr,i+1,key);
    } 

    //Q-2 Convert numbers into string of english
    static String digit[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    static void convertStr(int num){
        //base case
        if(num==0){
            return;
        }

        int lastDigit=num%10;    //kaam
        convertStr(num/10);      //call
        System.out.print(digit[lastDigit]+" ");
    }
    //Q-3 find length of string
    static int length(String str){
        if(str.length()==0){
            return 0;
        }

        return length(str.substring(1))+1;
    }
    //Q-4 count the substring which start and end with same character
    static int sameSubstringChar(String str, int i, int count){
        if(i==str.length()){
            return count;
        }
        //kaam
        for(int j=i; j<str.length(); j++){
            if(str.charAt(i)==str.charAt(j)){
                count++;
            }
        }
        return sameSubstringChar(str, i+1, count);
    }
    //Q-5 Tower of Hanoi 
    static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n==1){
            System.out.println("transfer disk "+ n + " from " + src + " to " + dest);
            return;
        }

        //transfer n-1 disk from src to helper using dest as helper
        towerOfHanoi(n-1, src, dest, helper);

        //transfer nth from src to dest
        System.out.println("transfer disk " + n + " from " + src + " to " + helper);

        //transfer n-1 from helper to dest using src as helper 
        towerOfHanoi(n-1, helper, src, dest);


    }
    
    public static void main(String[] args){
        //int arr[]={3, 2, 4, 5, 6, 2, 7, 2, 2};
        //findKeys(arr, 0, 2);
        //convertStr(1905);
        //System.out.println(length("abcd"));
        //int ans=sameSubstringChar("abcab", 0, 0);
        //System.out.println(ans);
        int n=3;
        towerOfHanoi(n, "A", "B", "C");
    }
}
