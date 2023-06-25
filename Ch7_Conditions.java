import java.util.*;

public class Ch7_Conditions{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        //Q-2
        // double temp=103.5;
        // String ans=temp>100?"You have fever":"You dont have fever";
        // System.out.println(ans);

        //Q-5 check the year is leap year or not

        // int year=sc.nextInt();

        // boolean x= (year%4) ==0; 
        // boolean y= (year%100) !=0;
        // boolean z= ((year%100==0) && (year%400==0)); 

        // if(x&& (y||z)) {
        //     System.out.println(year+" is a leap year");
        // }else{
        //     System.out.println(year+" is not a leapyear");
        // }

        int yr = sc.nextInt();

        String ans = (((yr%4==0)&&(yr%100!=0)) || (yr%400==0))? "This is Leap Year" : "This is not a Leap year";
        System.out.println(ans);

        
    }
}