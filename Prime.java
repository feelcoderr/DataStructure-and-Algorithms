import java.util.*;
public class Prime {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any number");
        int n= sc.nextInt();

        boolean isPrime= true;

        for(int i=2;i<Math.sqrt(n);i++){
            if(n==2){
                isPrime=true;
            }
            else{
                if(n%i==0){
                    isPrime= false;
                }
            }
        }

        if(isPrime){
            System.out.println(n+" is Prime number");
        }else{
            System.out.println(n+" is Not a Prime number");
        }
    }
}
