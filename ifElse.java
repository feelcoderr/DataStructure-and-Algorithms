import java.util.*;

public class ifElse {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();


        // if(a>=b){
        //     if( (a%2)==0){
        //     System.out.println( "Even "+ a +" is Greater" );
        //     } else{
        //         System.out.println("Odd "+ a +" is Greater");
        //     }
        // }
        // else {
        //     if( (b%2)==0){
        //     System.out.println( "Even "+ b +" is Greater" );
        //     } else{
        //         System.out.println("Odd "+ b +" is Greater");
        //     }}
        
        int max = a>b? a:b;
        String type =( max%2)==0?"Even":"Odd";

        System.out.println("max number is "+ type + " " + max );
    }
}
