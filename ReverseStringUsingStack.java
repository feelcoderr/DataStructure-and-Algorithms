import java.util.Stack;
import java.util.*;
public class ReverseStringUsingStack {
    public static String reverseString(String str){
        Stack<Character> s= new Stack<Character>();
        StringBuilder sb= new StringBuilder();
        int idx=0;
        //push string in stack
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        //pop string from stack
        while(!s.empty()){
            sb.append(s.pop());
        }
        return sb.toString();
    }
    public static void main(String args[]){
        String str="abc";
        System.out.println(reverseString(str));
    }
}
