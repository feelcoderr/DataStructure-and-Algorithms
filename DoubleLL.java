public class DoubleLL {
    class node{
        int data;
        node next;
        node prev;

        public node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static node head;
    public static node tail;
    public static int size;

    public node addFirst(int data){
        node newNode=new node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            head.next=null;
            head.prev=null;
        }
        newNode.prev=null;
        newNode.next=head;
        head=newNode;

        return head;
    }

    public node addLast(int data){
        node newNode=new node(data);
        size++;
        if(head==null){
            newNode.next=null;
            newNode.prev=null;
            head=tail=newNode;
        }
        newNode.next=null;
        newNode.prev=tail;
        tail.next=newNode;
        tail=newNode;

        return head;
    }

    public node removeFirst(){
        if(head.next==null){
            head=tail=null;
        }
        size--;
        head=head.next;
        head.prev=null;

        return head;

    }

    public node removeLast(){
        if(head.next==null){
            head=tail=null;
        }
        size--;
        tail=tail.prev;
        tail.next=null;

        return head;
    }

    public node remove(int idx){
        node temp=head;
        for(int i=1; i<idx; i++){
            temp=temp.next;
        }
        if(temp==null){
            return removeFirst();
        }
        else if(temp.next.next==null){
            return removeLast();
        }
        size--;
        temp.next=temp.next.next;
        temp.next.next.prev=temp;

        return head;
    }

    public node reverseDLL(){
        node curr=tail=head;
        node prev=null;
        node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        return head=prev;
    }

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

    public void printdll(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        DoubleLL dll= new DoubleLL();

        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(3);
        dll.addLast(4);
        dll.printdll();

        //dll.removeFirst();
        //dll.removeLast();
        //dll.remove(2);

        dll.reverseDLL();
        dll.printdll();
    }
}
