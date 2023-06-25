import java.util.*;
public class Break {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        // int num=1;
        // do{
        //     if(num==4){
        //         break;
        //     }
        //     System.out.println(num);
        //     num++;
        // }while(num<5);
        
        // System.out.println("This is breaked");

        //Break when number is multiple of 10

        do{
            System.out.println("Enter any number");
            int num = sc.nextInt();
            if(num%10==0){
                break;
            }
            System.out.println(num);
        }while(true);
    }
}
