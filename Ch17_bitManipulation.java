public class Ch17_bitManipulation {
    //odd or even by bitmanipulation
    public static void oddOrEven(int n){
        int bitMask=1;
        if((n & bitMask) == 1){
            System.out.println(n +" is odd");
        }else{
            System.out.println(n +" is even");
        }
    }
    //Clear i th bit
    public static int clearBit(int n, int i){
        int bitMask= ~(1<<i);
        n=(n & bitMask);
        System.out.println(n);
        return n;
    }
    //Set i th bit
    public static int setBit(int n, int i){
        int bitMask= (1<<i);
        n= n| bitMask;
        System.out.println(n);
        return n;
    }
    //update ith bit
    public static void updateBit(int n, int i, int newBit){
        // if(newBit==0){
        //     //Clear ith bit
        //     int bitMask= ~(1<<i);
        //     n=(n & bitMask);
        //     System.out.println(n);
        // }else{
        //     //Set ith bit
        //     int bitMask= (1<<i);
        //     n= n| bitMask;
        //     System.out.println(n);
        // }

        //first clear ith bit
        n=clearBit(n, i);

        int bitMask=(newBit<<i);
        n= n | bitMask;
        System.out.println(n);
    }

    //Clear last i bits
    public static int clearLastIBits(int n, int i){
        int bitMask=(~0)<<i;
        n=n & bitMask;
        System.out.println(n);
        return n;
    }
    
    //Clear i bits from range
    public static int clearBitsInRange(int n, int i, int j){
        int a=(~0)<<j+1;
        int b=(1<<i)-1;
        int bitMask= a|b;
        n= n & bitMask;
        System.out.println(n);
        return n;

    }

    //Chack if number is power of two or not
    public static boolean isPowerOfTwo(int n){
        if((n & (n-1))==0){
            System.out.println(true);
            return true;
        }else{
            System.out.println(false);
            return false;
        }
    }

    //Fast Exponentiation
    public static int fastExpo(int a, int n){
        int ans=1;
        
        while(n>0){
            if((n & 1) != 0){
                ans = a * ans;
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }
    public static void main(String args[]){
        //oddOrEven(348902);
        int n=16, i=4, j=7, newBit=0;
        // setBit(n, i);
        // clearBit(n, i);
        // updateBit(n, i, newBit);
        // clearLastIBits(n, i);
        // clearBitsInRange(n, i, j);
        // isPowerOfTwo(n);
        System.out.println(fastExpo(5,3));
    }
}
