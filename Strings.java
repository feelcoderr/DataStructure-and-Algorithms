import java.util.*;

public class Strings {

    //Is Palindromic
    public static boolean isPalindromic(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                System.out.println("Not Palindromic!");
                return false;
            }
        }
        System.out.println(str+" is Palindromic word");
        return true;
    }

    //get Shortest path
    public static float getShortestPath(String str){
        int x=0,y=0;
        for(int i=0; i<str.length(); i++){
            char dir= str.charAt(i);
            //North
            if(dir=='N'){
                y++;
            }
            //South
            else if(dir=='S'){
                y--;
            }
            //East
            else if(dir=='E'){
                x++;
            }
            //West
            else{
                x--;
            }
        }
        int X2= x*x;
        int Y2= y*y;
        float distance= (float)Math.sqrt(X2+Y2);
        return distance;
    }

    //SubString
    public static String subString(String str, int si, int ei){
        String subStr= "";
        for(int i=si; i<ei; i++){
            subStr += str.charAt(i);
        }
        return subStr;
    }

    //return Largest string out of set of strings
    public static String getLargest(String str[]){
        String largest= str[0];
        for(int i=1; i<str.length; i++){
            if(largest.compareToIgnoreCase(str[i])<0){
                largest=str[i];
            }
        }
        return largest;
    }

    //String Builder - to edit any string
    public static void editString(){
        StringBuilder sb = new StringBuilder("");
        for(char ch='a'; ch<'z'; ch++){
            sb.append(ch);
        }
        System.out.println(sb);
    }

    //Make First latter of word in string Uppercase
    public static StringBuilder makeUpperCase(String str){
        StringBuilder sb= new StringBuilder("");

        //add first latter to sb by making it Upparcase
        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb;
    }

    //String Compration
    public static StringBuilder stringCompration(String str){
        StringBuilder compStr= new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            int count=1;
            compStr.append(str.charAt(i));
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            if(count!=1){
                compStr.append(count);
            }
        }
        return compStr;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //method to make string variable
        /*
        String name= "Yash";
        String name2= new String("Yash");
        */

        //take input as string
        /* 
        String firstName= sc.next();// it will take only word
        String fullName= sc.nextLine();//it will take whole sentance
        */

        //concatenate(to add)
        /* 
        String firstName= "Solanki ";
        String fullName= firstName+"Yogesh";
        */

        //isPalindromic("RACecar");

        //String str="WNEENESENNN";
        //System.out.println(getShortestPath(str));

        //SubStrings
        //String str="Hello World";
        //System.out.println(subString(str, 3, 9));
        //System.out.println(str.substring(3,8));

        //Largest String
        // String str[]= {"apple","banana","mango"};
        // System.out.println(getLargest(str));
        
        //editString();
 
        //String str= "hi, i am yogesh ";
        //System.out.println(makeUpperCase(str));

        String str="abdbb";
        System.out.println(stringCompration(str));
    }
}
