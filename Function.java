import java.util.*;
public class Function {

    public static int factorial(int n){
        int fact=1;

        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }

    public static int binCoeff(int n, int r){
        int binomialCoefficient= factorial(n)/(factorial(r)*factorial(n-r));
        return binomialCoefficient;
    }

    public static boolean isPrime(int n){
        if(n==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void primesInRange(int n){
        for(int i=2; i<=n; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static int binToDec(int binNum){
        int decNum=0;
        int pow=0;

        while(binNum>0){
            int lastDigit=binNum%10;

            decNum= decNum+ (lastDigit*(int)Math.pow(2,pow));
            pow++;
            binNum=binNum/10;
        }
        return decNum;
    }

    public static int decToBin(int decNum){
        int binNum=0;
        int pow=0;
        
        while(decNum>0){
            int rem= decNum%2;

            binNum= binNum+(rem*(int)Math.pow(10,pow));

            pow++;
            decNum=decNum/2;
        }

        return binNum;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println(decToBin(11));

    }
}

