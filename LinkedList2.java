public class LinkedList2 {
    public class node {
        int data;
        node next;

        public node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static node head;
    static node tail;
    static int size;

    public void addFirst(int data){
        node newNode=new node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data){
        node newNode=new node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            newNode.next=null;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        node newNode= new node(data);
        size++;
        int i=0;
        node tamp=head;
        while(i<idx-1){
            tamp=tamp.next;
            i++;
        }
        newNode.next=tamp.next;
        tamp.next=newNode;
        return;
    }
    public void printll(){
        if(head==null){
            System.out.println(head);
            return;
        }
        node tamp=head;
        while(tamp!=null){
            System.out.print(tamp.data+"->");
            tamp=tamp.next;
        }
        System.out.println();
        return;
    }

    //Q-1 Remove cycle from ll
    public void removeCycle(){
        //detect cycle (floid's algo)
        node slow=head;
        node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2

            //if it has cycle at one node slow==fast
            if(slow==fast){
                cycle=true;
                break;
            }
        }

        if(cycle==false){
            return;
        }


        //make slow=head and slow+1 and fast+1
        slow=head;
        node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;//+1
            fast=fast.next;//+1
        }

        //make lastnode.next =null of fast
        prev.next=null;

    }
    public static void main(String args[]){
        LinkedList ll= new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2,3);

        //make cycle
        //tail.next=head;
        //ll.removeCycle();
        ll.printLL();
    }
}
