public class Ch33_Assignment {
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

    public static int sumOfRange(Node root, int sum, int st, int end){
        if(root == null){
            return sum;
        }
        if(root.data > st && root.data <end){
            sum += root.data;
        }
        if(root.left != null && root.left.data > st){
            sum = sumOfRange(root.left, sum, st, end);
        }
        if(root.right != null && root.right.data < end){
            sum = sumOfRange(root.right, sum, st, end);
        }

        return sum;
    }
    public static void main(String args[]){
        
    }
}
