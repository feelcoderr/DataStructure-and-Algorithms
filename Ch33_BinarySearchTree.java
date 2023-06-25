import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
public class Ch33_BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    //Sorted array to Balanced BST
    public static Node createBST(int arr[], int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }

    //Convert BST to Balanced BST
    public static Node convertBalancedBST(Node root){
        //get Sorted Array
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root, inorder);
        System.out.println(inorder);
        //get balaced tree from sorted array
        root = getBalancedBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static void getInOrder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        getInOrder(root.left, inorder);
        inorder.add(root.data);
        getInOrder(root.right, inorder);
        return;
    }

    public static Node getBalancedBST(ArrayList<Integer> inorder, int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st + end)/ 2;
        Node root = new Node(inorder.get(mid));
        root.left = getBalancedBST(inorder, st, mid-1);
        root.right = getBalancedBST(inorder, mid + 1, end);

        return root;
    }

    //Size of Largest BST in BT
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        //calculate size and max, min for subtree
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        //chack is BST
        if(root.data <= leftInfo.max || root.data >= rightInfo.min){//invalid
            return new Info(false, size, min, max);
        }

        //if valid than 
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    //Merge 2 BST 
    public static Node mergeBST(Node root1, Node root2){
        //get inorder sequence of BST's
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root1, arr1);
        getInOrder(root2, arr2);

        //Merge arrays
        ArrayList<Integer> arr = new ArrayList<>();
        int i=0;
        int j=0;
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                arr.add(arr1.get(i));
                i++;
            }else{
                arr.add(arr2.get(j));
                j++;
            }
        }
        while(i < arr1.size()){
            arr.add(arr1.get(i));
            i++;
        }
        while(j < arr2.size()){
            arr.add(arr2.get(j));
            j++;
        }


        //convert sorted ArrayList into BST
        Node root = getBalancedBST(arr, 0, arr.size() - 1);
        return root;
    }

    //InOrder
    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //preOrder
    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    //LevelOrder
    public static void levelorder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

    }

    public static void main(String args[]){
        // int values[] = {8, 5, 3, 1, 4, 6, 10 , 11, 14};
        // Node root = null;

        // for(int i=0; i<values.length; i++){
        //     root = insert(root, values[i]);
        // }

        // int arr[] = {3, 5, 6 , 8, 10, 11, 12};
        // Node root = createBST(arr, 0, arr.length - 1);

        //inorder(root);

        //unBalanced tree
        //        8
        //       / \ 
        //      6   10
        //     /      \
        //    5        11
        //   /          \
        //  3            12

        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.right = new Node(10);
        // root.left.left = new Node(5);
        // root.right.right = new Node(11);
        // root.left.left.left = new Node(3);
        // root.right.right.right = new Node(12);

        // levelorder(root);

        // root = convertBalancedBST(root);

        
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // largestBST(root);
        // System.out.println(maxBST);


        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        levelorder(root);
        
    }
}
