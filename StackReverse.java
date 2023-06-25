import java.util.*;
import java.util.Stack;
public class StackReverse {
    public static void reverseStack(Stack<Integer> s){
        //base case
        if(s.empty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void pushAtBottom(Stack<Integer> s, int data){
        //base case
        if(s.empty()){
            s.push(data);
            return ;
        }
        int top= s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
    public static void printStack(Stack<Integer> s){
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String args[]){
        Stack<Integer> s= new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);

        reverseStack(s);
        printStack(s);
    }
}
