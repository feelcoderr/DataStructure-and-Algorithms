import java.util.*;

public class SwitchStatement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int number= sc.nextInt();

        switch(number){
            case 1: System.out.println("You are First");
                    break;
            case 2: System.out.println("You are Second");
                    break;
            case 3: System.out.println("You are Third");
                    break;
            default:
                    System.out.println("You are late!");
        }
    }
}
