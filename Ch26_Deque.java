import java.util.*;
import java.util.LinkedList;
public class Ch26_Deque {
    //Stack and Queue implementation using Deque
    static class Stack{
        Deque<Integer> dq = new LinkedList<>();
        //isEmpty
        public boolean isEmpty(){
            return dq.isEmpty();
        }
        //push
        public void push(int data){
            dq.addLast(data);
        }
        //pop
        public int pop(){
            return dq.removeLast();
        }
        //peek
        public int peek(){
            return dq.getLast();
        }
    }
    static class Queue{
        Deque<Integer> dq = new LinkedList<>();

        //isEmpty
        public boolean isEmpty(){
            return dq.isEmpty();
        }
        //add
        public void add(int data){
            dq.addLast(data);
        }
        //remove
        public int remove(){
            return dq.removeFirst();
        }
        //peek
        public int peek(){
            return dq.getFirst();
        }
    }
    public static void  main(String args[]){
        // Deque<Integer> dq = new LinkedList<>();
        // dq.addFirst(1);
        // dq.addFirst(2);
        // dq.addLast(3);
        // dq.addLast(4);
        // System.out.println(dq);

        // dq.removeFirst();
        // dq.removeLast();
        // System.out.println(dq);

        // System.out.println(dq.getFirst());
        // System.out.println(dq.getLast());
        // dq.remove();
        // dq.add(1);
        // System.out.println(dq);

        //stack
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        System.out.println(s.peek());
        System.out.println(s.pop());
        //Queue
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        System.out.println(q.peek());
        System.out.println(q.remove());

    }
}

