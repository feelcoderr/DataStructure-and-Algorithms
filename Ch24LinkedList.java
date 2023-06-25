public class Ch24LinkedList {
    class node{
        int data;
        node next;

        public node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static node head;
    public static node tail;
    public static int size;

    // public node insert(node head1, node tail, int idx){
    //     node temp=head1;
    //     int i=0;
    //     while(i<idx-1){
    //         temp=temp.next;
    //     }
    //     tail.next=temp.next;
    // }
    //Q-1 intersection of singly linkedList
    public node getIntersection(node h1, node h2){
        node temp1=h1;
        node temp2=h2;
        node common=null;
        while(temp1!=null){
            while(temp2!=null){
                if(temp1.next==temp2.next){
                    common=temp1.next;
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return common;
    }

    public void printll(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        LinkedList ll= new LinkedList();
        LinkedList pll= new LinkedList();
        pll.addFirst(6);
        pll.addFirst(7);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addLast(4);
        ll.addLast(5);
        //ll.insert(head, tail, 2);
        ll.printLL();
        pll.printLL();
    }
}
