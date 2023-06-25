import java.util.*;
import java.util.LinkedList;
import java.util.HashMap;

public class Ch30_BinaryTree2 {
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
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int node[]){
            idx++;
            //base case
            if(node[idx] == -1){
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);

            return newNode;
        }
        
    }
    public static int height(Node root){
            if(root == null){
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh)+1;
    }

    //Diameter of a tree
    public static int treeDiam(Node root){
        //base case
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        int selfDiam = (lh + rh + 1); // Diameter include root Node
        int lDiam = treeDiam(root.left); // Diameter of left subtree
        int rDiam = treeDiam(root.right); // Diameter of right subtree

        return Math.max(selfDiam, Math.max(lDiam, rDiam));

    }

    //optimised approch of Diameter of tree
    // public static class Info{
    //     int diam;
    //     int height;
    //     public Info(int d, int h){
    //         this.diam = d;
    //         this.height = h;
    //     }
    // }
    // public static Info diameter(Node root){
    //     if(root == null){
    //         return new Info(0, 0);
    //     }

    //     Info linfo = diameter(root.left);
    //     Info rinfo = diameter(root.right);

    //     int selfDiam = linfo.height+rinfo.height+ 1; // diameter includeing root
    //     int diam = Math.max(selfDiam, Math.max(linfo.diam,rinfo.diam));

    //     return new Info(diam, Math.max(linfo.height, rinfo.height) + 1);
    // }


    //Subtree of another tree
    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }
        
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    //Top view of tree
    static class Info{
        Node node;
        int hd;
        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        //Level order traversal
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){ // first ocurrence of horizontal distance
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
                
            }
        }
        for(int i=min; i<=max ; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        // int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        //Node root = tree.buildTree(node);

        // System.out.println(height(root));
        // System.out.println(treeDiam(root));
        // Info ans = diameter(root);
        // System.out.println(ans.diam);


        //          1
        //         / \ 
        //        2    3
        //       / \    \ 
        //      4   5    6
        BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        BinaryTree subTree = new BinaryTree();
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));

        topView(root);
        
    }
}
