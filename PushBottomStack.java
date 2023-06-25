import java.util.*;
import java.util.Stack;
public class PushBottomStack {
    public static void pushAtBottom(Stack<Integer> s, int data){
        //base case
        if(s.empty()){
            s.push(data);
            return;
        }

        int top= s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String args[]){
        Stack<Integer> s= new Stack<Integer>();
        s.push(2);
        s.push(3);
        s.push(1);

        pushAtBottom(s, 4);
        while(!s.empty()){
            System.out.print(s.pop());
        }
    }
}
