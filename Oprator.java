import java.util.*;

public class Oprator{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);


        // int num1 = sc.nextInt();
        // int num2 = sc.nextInt();

        // System.out.println("Sum is " + (num1+num2));
        // System.out.println("Substaction is " + (num1-num2));
        // System.out.println("Multiplication is " + num1*num2);
        // System.out.println("Division is " + num1/num2);
        // System.out.println("Remainder is " + num1%num2);

        // System.out.println(num1*num2/num1);
        // System.out.println(num1*(num2/num1));

        int x = 9, y = 12;
        int a = 2, b = 4, c = 6;
        int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y);
        int exp2=(a + b*y);
        int exp3=(3 + y * (2 + a));
        int exp4=9 * (a + b * c);
        int exp5=4/3 * (x + 34);
        System.out.println(exp);
        System.out.println(exp2);
        System.out.println(exp3);
        System.out.println(exp4);
        System.out.println(exp5);
    }
}