import java.util.*;
public class Comp3num {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int a= sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();

        int max;

        if(a>b && a>c){
            max=a;
        }else if(b>c){
            max=b;
        }else{
            max=c;
        }

        System.out.println("Max number is : " + max);

    }
}
