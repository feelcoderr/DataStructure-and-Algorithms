import java.net.http.HttpHeaders;
import java.util.*;
import java.util.LinkedList;
import java.util.Stack;
public class Ch25_Assignment {
    //Q-1 check Linked List is palindrom or not
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    // public static void add(int data){
    //     Node newNode = new Node(data);

    // }
    // public static boolean isPalindrom(){
    //         Stack<Integer> s = new Stack<>();
    //         int i = 0;
            
    //     }
    public static void main(String args[]){
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('A');
        ll.add('B');
        ll.add('C');
        ll.add('B');
        ll.add('C');
        System.out.println(ll.getFirst());
        System.out.println(ll.size());

        
    }
}
