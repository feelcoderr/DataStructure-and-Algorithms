import java.util.*;
public class SwapFun {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Velue of A");
        int a= sc.nextInt();
        
        System.out.println("Enter Velue of B");
        int b= sc.nextInt();

        int temp= a;
        a=b;
        b=temp;

        System.out.println("Enter Velue of A is : " + a);
        System.out.println("Enter Velue of B is : " + b);


    }
}
