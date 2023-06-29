import java.util.*;

public class Revision {
    /* Binary to decimal */
    public static int binToDec(int binNum) {
        int decNum = 0;
        double pow = 0;
        while (binNum > 0) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));
            pow++;
            binNum /= 10;
        }

        return decNum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter binary number");
        int binNum = sc.nextInt();
        System.out.println(binToDec(binNum));
    }
}
