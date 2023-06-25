import java.util.*;
public class Ch32_BinarySearchTree {
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

    //Build BST
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }
        else{
            //right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    //Search in BST
    public static boolean search(Node root, int key){ // O(H)
        //base case
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }
        
        if(root.data > key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }

    //Delete Node in BST
    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{//Voila

            //case 1 : leaf Node
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2 : single child
            if(root.left == null){
                return root.right;
                 
            }
            else if(root.right == null){
                root = root.left;
                return root;
            }
            //case 3 : both child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;

    }
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //Print Range of Nodes
    public static void printRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(k1 <= root.data && root.data <= k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printRange(root.left, k1, k2);
        }else{
            printRange(root.right, k1, k2);
        }
    }

    //Root to leaf paths
    public static void root2LeafPaths(Node root, ArrayList<Node> path){
        if(root == null){
            return;
        }
        path.add(root);
        if(root.left == null && root.right == null){
            printPath(path);
            return;
        }
        root2LeafPaths(root.left, path);
        root2LeafPaths(root.right, path);
        path.remove(path.size() - 1);
    }
    public static void printPath(ArrayList<Node> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i).data + "-> ");
        }
        System.out.println("Null");
    }

    //Valid BST
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    //Mirror BST
    public static Node mirrorBST(Node root){
        if(root == null){
            return root;
        }

        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    //Inorder traversal
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String args[]){
        int values[] = {8, 5, 3, 1, 4, 6, 10 , 11, 14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        //inOrder(root);
        // System.out.println(search(root, 8));

        // delete(root, 1);
        // inOrder(root);

        //printRange(root, 8, 15);

        // ArrayList<Node> path = new ArrayList<>();
        // root2LeafPaths(root, path);

        //System.out.println(isValidBST(root, null, null));

        mirrorBST(root);
        inOrder(root);

    }
}
