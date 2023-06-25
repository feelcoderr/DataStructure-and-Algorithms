import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Ch26_Queue {
    // static class Queue{
    //     static int arr[];
    //     static int size;
    //     static int rear;

    //     Queue(int n){
    //         arr = new int [n];
    //         size = n;
    //         rear = -1;
    //     }

    //     //Is Empty
    //     static boolean isEmpty(){
    //         return rear == -1;
    //     }

    //     //add
    //     static void add(int data){
    //         if(rear == size-1){
    //             System.out.println("Queue is full");
    //             return;
    //         }

    //         rear++;
    //         arr[rear] = data;
    //     }

    //     //remove
    //     static int remove(){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         int front = arr[0];
    //         for(int i=0; i<rear; i++){
    //             arr[i] = arr[i+1];
    //         }
    //         rear--;
    //         return front;
    //     }

    //     //peek
    //     static int peek(){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         int front = arr[0];
    //         return front;
    //     }
    // }

    //Circular Queue

    // static class Queue{
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     static int front;

    //     Queue(int n){
    //         arr = new int [n];
    //         size = n;
    //         rear = -1;
    //         front = -1;
    //     }

    //     //Is Empty
    //     static boolean isEmpty(){
    //         return rear == -1 && front == -1;
    //     }

    //     //Is full
    //     static boolean isFull(){
    //         return (rear + 1) % size == front;
    //     }

    //     //add
    //     static void add(int data){
    //         if(isFull()){
    //             System.out.println("Queue is full");
    //             return;
    //         }
    //         //add first element
    //         if(front == -1){
    //             front = 0;
    //         }
    //         rear = (rear + 1) % size;
    //         arr[rear] = data;
    //     }

    //     //remove
    //     static int remove(){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         int result = arr[front];
            
    //         //delete last element
    //         if(front == rear){
    //             front = rear = -1;
    //         }else{
    //             front = (front + 1) % size;
    //         }
    //         return result;
    //     }

    //     //peek
    //     static int peek(){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         return arr[front];
    //     }
    // }

    // * Queue using LinkedList
    // static class Node{
    //     int data;
    //     Node next;

    //     Node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class Queue{
    //     static Node head = null;
    //     static Node tail = null;

    //     //Is Empty
    //     static boolean isEmpty(){
    //         return head == null && tail == null;
    //     }

    //     //add
    //     static void add(int data){
    //         Node newNode = new Node(data);
    //         if(head == null){
    //             head = tail = newNode;
    //             return;
    //         }
    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     //remove
    //     static int remove(){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         int result = head.data;
    //         if(head == tail){
    //             head = tail = null;
    //         }else{
    //             head = head.next;
    //         }
    //         return result;
    //     }

    //     //peek
    //     static int peek(){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    //Implementation using 2 stacks
    // static class Queue{
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();

    //     //is Empty
    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }

    //     //add
    //     public static void add(int data){
    //         if(isEmpty()){
    //             s1.push(data);
    //             return;
    //         }

    //         while(!s1.isEmpty()){
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);

    //         while(!s2.isEmpty()){
    //             s1.push(s2.pop());
    //         }
    //     }

    //     //remove
    //     public static int remove(){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }

    //     //peek
    //     public static int peek(){
    //         return s1.peek();
    //     }
    // }

    //Q-2 implement stack using two Queue
    // static class Stack{
    //     static Queue<Integer> q1 = new LinkedList<>();
    //     static Queue<Integer> q2 = new LinkedList<>();

    //     //isEmpty
    //     static boolean isEmpty(){
    //         return q1.isEmpty() && q2.isEmpty();
    //     }

    //     //push
    //     static void push(int data){
    //         if(!q1.isEmpty()){
    //             q1.add(data);
    //         }else{
    //             q2.add(data);
    //         }
    //     }

    //     //pop
    //     static int pop(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top = -1;
    //         if(!q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top = q1.remove();
    //                 if(q1.isEmpty()){
    //                     break;
    //                 }
    //                 q2.add(top);
    //             }
    //         }else{
    //             while(!q2.isEmpty()){
    //                 top = q2.remove();
    //                 if(q2.isEmpty()){
    //                     break;
    //                 }
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }

    //     //peek
    //     static int peek(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top = -1;
    //         if(!q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top = q1.remove();
    //                 q2.add(top);
    //             }
    //         }else{
    //             while(!q2.isEmpty()){
    //                 top = q2.remove();
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }

    // }

    //First non repeating letter in stream of character
    public static void firstNonRepeating(String str){
        //create arr for frequecy of char A - Z
        int freq[] = new int[26];

        //create queue to store non repeating letter
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            freq[ch - 'a'] ++ ;
            q.add(ch);
            //check in queue for first non repeating letter
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }else{
                System.out.print(q.peek() + " ");
            }
        }
    }

    //Interleave 2 halves of Queue
    public static Queue<Integer> interleave2Halves(Queue<Integer> q ){
        int half = q.size()/2;
        Queue<Integer> first = new LinkedList<>();
        //divide in half
        for(int i=0; i<half; i++){
            first.add(q.remove());
        }
        //add one-one elements of both
        for(int i=0; i<half; i++){
            q.add(first.remove());
            q.add(q.remove());
        }
        return q;
    }

    //Reverse Queue
    public static Queue<Integer> reverseQueue(Queue<Integer> q){
        //create stack to reverse queue
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        return q;
    }
    public static void main(String args[]){
        //Queue q = new Queue();
        
        //JCF implementation
        //Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();

        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        

        // System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);

    // while(!q.isEmpty()){
    //     System.out.println(q.peek());
    //     q.remove();
    // }

        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // String str = "aabccxb";
        // firstNonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
            q.add(1);q.add(2);q.add(3);q.add(4);q.add(5);
            q.add(6);q.add(7);q.add(8);q.add(9);q.add(10);

        // q = interleave2Halves(q);
        q = reverseQueue(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
