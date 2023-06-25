
public class LinkedList {
    public class node{
        int data;
        node next;

        //constructor
        public node(int data){
            this.data= data;
            this.next=null;
        }
    }

    static node head;
    static node tail;
    static int size;

    public void addFirst(int data){
        //step1- create new node
        node newNode= new node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        //step2- newNode's next = head
        newNode.next=head;

        //step3- store newNode in head head=newNode
        head=newNode;


    }

    public void addLast(int data){
        //step1- create new node
        node newNode= new node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        //step2- tail's next=newNode
        tail.next=newNode;

        //step3- tail=newNode
        tail=newNode;
    }

    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        node newNode= new node(data);
        size++;
        node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("It's empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("its empty");
            return Integer.MAX_VALUE;
        }
        else if(size==1){
            int val=tail.data;
            head=tail=null;
            size--;
            return val;
        }
        node prev= new node(head.data);
        node temp=head.next;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        int val=prev.data;
        prev.next=null;
        size--;
        return val;
    }

    //Print LinkedList
    public void printLL(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-> ");
            temp=temp.next;
            
        }
        System.out.println("null");
    }

    public int itrSearch(int key){
        int i=0;
        node temp=head;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            else{
                temp=temp.next;
                i++;
            }
        }
        return -1;
    }

    public int helper(node head, int key){
        //base case
        if(head==null){
            return -1;
        }
        //kaam
        if(head.data==key){
            return 0;
        }
        //call
        int idx=helper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    //Reverse LinkedList
    public void reverseLL(){
        node prev=null;
        node curr= tail= head;
        node next;

        while(curr!= null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    // ** Find and Remove nth node from end

    public void removeNth(int n){
        //calculate size
        node temp=head;
        int llSize=0;
        while(temp!=null){
            temp=temp.next;
            llSize++;
        }
        //remove head
        if(size==n){
            head=head.next;
            return;
        }
        
        //make size-n node as prev node
        node prev=head;
        for(int i=1; i< llSize-n; i++){
            prev=prev.next;
        }
        //prev.next=nth node.next
        prev.next=prev.next.next;
    }
    //to find mid by Fast and slow approch
    public node findMid(node head){
        node fast=head;
        node slow=head;

        //for even size- fast!=null
        //for odd size- fast.next!= null
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;//+2
            slow=slow.next;//+1
        }
        return slow;
    }
    // *** check if linked list is palindrom or not
    public boolean checkPalindrom(){
        //corner case
        if(head==null || head.next==null){
            return true;
        }

        //step-1 find mid node
        node midNode= findMid(head);

        //step-2 reverse second half
        node prev=null;
        node curr=midNode;
        node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        node right=prev; // right head= last node

        //step-3 compare left and right part
        node left=head;
        while(right!=null && left!=null){
            //compare
            if(right.data!=left.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }
        return true;
    }

    public boolean checkCycle(){
        //floyd's cycle finding algorithem
        node slow=head;
        node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2

            if(slow==fast){
                return true;
            }
        }
        return false;
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

    //Merge sort
    public node getMid(node head){
        //slow-fast approch
        node slow=head;
        node fast=head.next;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public node merge(node lh, node rh){
        node mergell=new node(-1);
        node temp=mergell;

        while(lh!=null && rh!=null){
            if(lh.data<=rh.data){
                temp.next=lh;
                temp=temp.next;
                lh=lh.next;
            }
            else {
                temp.next=rh;
                temp=temp.next;
                rh=rh.next;
            }
        }
        //if left remains
        while(lh!=null){
            temp.next=lh;
            temp=temp.next;
            lh=lh.next;
        }
        //if right remains
        while(rh!=null){
            temp.next=rh;
            temp=temp.next;
            rh=rh.next;
        }
        return mergell.next;
    }
    public node mergeSort(node head){
        //base case
        if(head.next==null || head==null){
            return head;
        }
        //kaam
        //find mid
        node mid=getMid(head);

        node right=mid.next;
        mid.next=null;

        //Left & right MS
        node newLeft=mergeSort(head);
        node newRight=mergeSort(right);

        //call to merge
        return merge(newLeft, newRight);
    }
    
    //Q-4 convert Zig-Zag linkedList
    public node getMidZigZag(node head){
        node slow=head;
        node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public node reverseLL(node head){
        node prev=null;
        node curr=head;
        node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public node zigZag(node head){
        //step-1 find mid
        node mid=getMidZigZag(head);
        node right=mid.next;
        mid.next=null;

        //step-2 reverse right half
        node rh=reverseLL(right);
        node lh=head;

        //step-3 alternate merging
        node nextl, nextr;
        while(lh!=null && rh!=null){
            nextl=lh.next;
            nextr=rh.next;

            lh.next=rh;
            rh.next=nextl;

            lh=nextl;
            rh=nextr;
        }
        return head;
    }
    
     public static void main(String args[]){
        LinkedList ll= new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        //ll.add(2,1);
        // ll.removeFirst();
        // ll.removeLast();
        //ll.printLL();

        //System.out.println(ll.itrSearch(4));
        //System.out.println(ll.recSearch(9));

        //System.out.println(ll.size);

        //ll.reverseLL();

        //ll.removeNth(3);
        //ll.printLL();
        //System.out.println(ll.checkPalindrom());

        tail.next=head.next;
        System.out.println(ll.checkCycle());
        //ll.printLL();
        ll.removeCycle();
        System.out.println(ll.checkCycle());
        ll.printLL();
        //ll.head=ll.mergeSort(ll.head);
        //ll.printLL();

        ll.head=ll.zigZag(ll.head);
        ll.printLL();
    }
}
