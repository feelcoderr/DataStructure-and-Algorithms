import java.util.*;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Ch31_Assignment {
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

    //Q-1 chack if tree is Univalue or not
    public static boolean isUnivalue(Node root, int k){
        if(root == null){
            return true;
        }
        if(k == -1){
            k = root.data;
        }
        if(k != root.data){
            return false;
        }
        return isUnivalue(root.left, k) && isUnivalue(root.right, k);
    }

    //Q-2 Invert tree into mirror tree
    public static void invertTree(Node root){
        if(root == null){
            return;
        }

        invertTree(root.left);
        invertTree(root.right);

        //swap left and right node
        if(root.left != null && root.right != null){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        // else if(root.left == null){
        //     root.left = root.right;
        //     root.right = null;
        // }else{
        //     root.right = root.left;
        //     root.left = null;
        // }
    }

    //Q-3 Delete leaf Node with values x
    public static void deleteLeaf(Node root, int x){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null ){
            if(root.data == x)
                root = null;
            return;
        }else{
            if(root.left != null){
                deleteLeaf(root.left, x);
            }
            if(root.right != null){
                deleteLeaf(root.right, x);
            }
        }
        
    }

    //Q-4 Find all duplicate subTrees
    // public static ArrayList<Node> findDuplicateSubtree(Node root){
    //     ArrayList<Node> al = new ArrayList<>();

    //     if(isDuplicate(root.left)){
    //         al.add(root.left);
    //     }
    //     if(isDuplicate(root.right)){
    //         al.add(root.right);
    //     }
    //     return al;
    // }

    //Q-5 Maximum path Sum
    // public static int maxPathSum(Node root){
        
    // }
    //LevelOrder
    public static void levelOrder(Node root){
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
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
        System.out.println();
    }

    //preOrder
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Node root2 = new Node (3);
        // root2.left = new Node(3);
        // root2.right = new Node(3);

        // System.out.println(isUnivalue(root2, -1));

        // invertTree(root);
        // levelOrder(root);
        // preOrder(root);

        deleteLeaf(root, 5);
        levelOrder(root);
    }
}
