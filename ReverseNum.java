import java.util.*;
public class ReverseNum {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int num= sc.nextInt();

        // while(num>0){
        //     int lastDig = num%10;
        //     System.out.print(lastDig);
        //     num=num/10;
        // }

        int rev=0;
        while(num>0){
            int lastDig = num%10;
            rev=(rev*10)+lastDig;
            num=num/10;
        }
        System.out.print(rev);
    }
}
