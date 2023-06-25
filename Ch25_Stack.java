import java.util.Stack;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import java.util.ArrayList;
public class Ch25_Stack {
    //Implementation of Stack in ArrayList
    // static class Stack{
    //     ArrayList<Integer> list = new ArrayList<>();

    //     //is Empty
    //     public boolean isEmpty(){
    //         return list.size() == 0;
    //     }

    //     //Push
    //     public void push(int data){
    //         list.add(data);
    //         return;
    //     }

    //     //pop
    //     public int pop(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top = list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;
    //     }

    //     //peek
    //     public int peek(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return list.get(list.size()-1);
    //     }
    // }

    //Implementation of Stack in LinkedList
    // static class Node{
    //     int data;
    //     Node next;

    //     Node (int data) {
    //         this.data=data;
    //         this.next=null;
    //     }
    // }
    // static class Stack{
    //     static Node head= null;

    //     public boolean isEmpty(){
    //         return head==null;
    //     }

    //     //push
    //     public void push(int data){
    //         Node newNode = new Node(data);

    //         newNode.next=head;
    //         head=newNode;
    //         return;
    //     }

    //     //pop
    //     public int pop(){
    //         int top = head.data;
    //         head=head.next;
    //         return top;
    //     }

    //     //peak
    //     public int peek(){
    //         return head.data;
    //     }
    // }

    //Stock span
    public static void calcStockSpan(int stock[], int span[]){
        Stack<Integer> s = new Stack<>();

        span[0]=1;
        s.push(0);

        for(int i=1; i<stock.length; i++){
            int currPrice= stock[i];

            while(!s.isEmpty() && currPrice>stock[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }

    }

    //Next Greater
    public static void nextGreater(int arr[], int nxtGreater[]){
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nxtGreater[i] = -1;
            }
            else{
                nxtGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    //Valid Paranthesis
    public static boolean isValidParanthesis(String str){
        //create stack to store opening brackets
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){ //Opening 
                s.push(str.charAt(i));
            }

            else {
                if(s.isEmpty()){
                    return false;
                }
                char openBck = s.peek();
                if((openBck == '(' && ch == ')') ||
                    (openBck == '{' && ch == '}') ||
                    (openBck == '[' && ch == ']')){
                        s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }

    //Duplicate Parantheses
    public static boolean isDuplicatePara(String str){
        //create stack to store all opening and operands and operators
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            int count = 0;
            char ch = str.charAt(i);

            //push ch if its opning brackets or item
            if(ch != ')'){
                s.push(ch);
            }

            else{
                //find opening bracket in stack
                while(s.peek() != '('){
                    count++;
                    s.pop();
                }
                if(count < 1){//this is duplicate parantheses
                    return true;
                }
                else{
                    s.pop(); // pop opening bracket
                }
            }
        }
        return false;
    }

    //Max Area in Histogram
    public static int maxArea(int heights[]){
        int n = heights.length;
        //Calculate left Smaller
        Stack<Integer> s = new Stack<>();
        int ls[] = new int [n];
        
        for(int i=0; i<n; i++){ // O(n)
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ls[i]=-1;
            }
            else{
                ls[i]=s.peek();
            }
            s.push(i);
        }
        //Calculate Right Smaller
        s = new Stack<>();
        int rs[] = new int [n];
        for(int i=n-1; i>=0; i--){ //O(n)
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                rs[i]=n;
            }
            else{
                rs[i]=s.peek();
            }
            s.push(i);
        }

        //Calculate max area
        int maxArea = 0;

        for(int i=0; i<n; i++){ // O(n)
            int height = heights[i];
            int width = rs[i] - ls[i] - 1; //don't add limit bar
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
    public static void main(String args[]){
        Stack s = new Stack();
        // s.push(8);
        // s.push(7);
        // s.push(6);
        
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        
        // int stock[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stock.length];

        // calcStockSpan(stock, span);
        // for(int i=0; i<span.length; i++){
        //     System.out.print(span[i]+" ");
        // }

        // int arr[] = {6, 8, 0, 1, 3};
        // int nxtGreater[] = new int [arr.length];
        // nextGreater(arr, nxtGreater);
        // for(int i=0; i<nxtGreater.length; i++){
        //     System.out.print(nxtGreater[i] + " ");
        // }

        // String str = "{(){]}}";
        // System.out.println(isValidParanthesis(str));

        // String str = "(((a+b)+(c+d)))";
        // System.out.println(isDuplicatePara(str));

        int heights[] = {2, 4 ,3};
        System.out.println(maxArea(heights));
    }
}
