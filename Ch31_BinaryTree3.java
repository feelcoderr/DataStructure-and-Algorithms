import java.util.*;
// import java.util.ArrayList;
public class Ch31_BinaryTree3 {
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

    // Kth Level
    public static void kthLevel(Node root, int level, int k){
        //base case 
        if(root == null){
            return;
        }

        if(level == k){
            System.out.print(root.data + " ");
        }
        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }
    
    //Lowest common ancestor
    public static boolean getPath(ArrayList<Node> path, Node root, int n){
        if(root == null){
            return false;
        }

        path.add(root);
        if(root.data == n){
            return true;
        }
        if(getPath(path, root.left, n) || getPath(path, root.right, n)){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(path1, root, n1);
        getPath(path2, root, n2);

        //find last same node in path
        int i=0;
        for(; i<path1.size() && i<path1.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }

    //Lca - approch 2
    public static Node lca2(Node root, int n1, int n2){
        //base case 
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        //Only one subTree return valid lca then return it
        if(rightLCA == null){
            return leftLCA;
        }
        if(leftLCA == null){
            return rightLCA;
        }

        //if both subtree hava lca than root node is common lca
        return root;
    }

    //Minimun Distance between two nodes
    public static int NodesDistance(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);

        int dist1 = minDistance(lca, n1);
        int dist2 = minDistance(lca, n2);

        return dist1 + dist2;
    }
    public static int minDistance(Node root, int n){
        if(root == null)
            return -1;
        
        if(root.data == n)
            return 0;//distance from current root to n

        int leftDis = minDistance(root.left, n);
        int rightDis = minDistance(root.right, n);

        if(leftDis == -1 && rightDis == -1)
            return -1;

        if(leftDis != -1)
            return leftDis + 1;
        else
            return rightDis + 1;
    }

    //Kth Ancester
    public static int kthAncestor(Node root, int n, int k){
        if(root == null)
            return -1;
        
        if(root.data == n)
            return 0;

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if(max + 1 == k){
            System.out.println(root.data);
        }
        return max + 1;
    }

    //Transform into sum tree
    public static int transform(Node root){
        if(root == null){
            return 0;
        }

        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int leftSum = leftChild + (root.left == null? 0 : root.left.data );
        int rightSum = rightChild + (root.right == null? 0 :root.right.data);
        
        int data = root.data;
        root.data = leftSum + rightSum;
        return data;
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String args[]){
        // tree

        //       1
        //      / \
        //     2   3
        //    /   / \ 
        //   4   5   6

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        //kthLevel(root, 1, 3);

        // System.out.println(lca(root, 4, 5).data);
        // System.out.println(lca2(root, 6, 5).data);

        // System.out.println(NodesDistance(root, 2, 6));

        //kthAncestor(root, 5, 2);
        
        transform(root);
        preOrder(root);

    }
}
