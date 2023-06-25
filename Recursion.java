public class Recursion {
    // Print n to 1 numbers in decresing order
    static void printDec(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDec(n-1);
    }

    // print 1 to n numbers in increasing order
    static void printInc(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printInc(n-1);
        System.out.println(n);
    }

    //factorial of n 
    static int factorial(int n){
        if(n==1){
            return 1;
        }
        int fact= n * factorial(n-1);
        return fact;
    }

    // Sum of n natural number
    static int sumOfN(int n){
        if(n==1){
            return 1;
        }
        int sum= n+ sumOfN(n-1);
        return sum;
    }

    // Fibonacci series
    static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        
        int fibo= fibonacci(n-1)+ fibonacci(n-2);
        return fibo;
    }

    //Is Sorted?
    static boolean isSorted(int arr[], int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    //Find first occurence of key
    static int findFirstKey(int arr[], int i, int key){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return findFirstKey(arr, i+1, key);
    }

    //Find Last occurence of key
    static int findLastKey(int arr[], int i, int key){
        if(i==arr.length){
            return -1;
        }
        int isFound=findLastKey(arr, i+1, key);
        if(isFound == -1 && arr[i]==key){
            return i;
        }
        return isFound;
    }

    //Print x^n ( Time Complexity O(n^2) )
    static int power(int x, int n){
        if(n==1 || n==0){
            return x*n;
        }
        int sq= x * power(x,n-1);
        return sq;
    }

    //Optimize power (Time Complexity O(logn) )
    static int optimizePower(int x, int n){
        if(n==0){
            return 1;
        }
        int halfPower= optimizePower(x ,n/2);
        //if n is even
        if(n%2==0){
            return halfPower * halfPower;
        }
        //if n is odd
        return x* halfPower * halfPower;
    }

    public static void main(String args[]){
        //printDec(10);
        //printInc(10);
        //System.out.println(factorial(5));
        //System.out.println(sumOfN(5));
        //System.out.println(fibonacci(4));

        int arr[]= {3,5,0,0,6,5};
        //System.out.println(isSorted(arr, 0));
        //System.out.println(findFirstKey(arr, 0, 2));
        //System.out.println(findLastKey(arr, 0, 0));

        //System.out.println(power(0 , 4));
        System.out.println(optimizePower(2, 4));
    }
}
