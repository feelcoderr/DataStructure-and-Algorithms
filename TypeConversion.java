import java.util.*;

public class TypeConversion {
    public static void main (String args[]){
        Scanner sc= new Scanner(System.in);

        float $ = sc.nextInt();  //type conversion , implicit or widening conversion
        int num2= (int)$;        //Type Casting , narrowing or explecit conversion

        System.out.println(num2);
    }
}
