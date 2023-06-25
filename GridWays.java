public class GridWays {
    static int waysOfTarget(int i, int j, int n, int m){
        //base case
        if(i==n-1 && j==m-1){ // last cell case
            return 1;
        }else if(i==n || j==n){ // corner case
            return 0;
        }
        //kaam
        //choice down
        int w1=waysOfTarget(i, j + 1, n ,m);
        //choice right
        int w2=waysOfTarget(i + 1, j, n, m);
        return w1+w2;
    }
    public static void main(String args[]){
        int n=3, m=4;
        System.out.println(waysOfTarget(0, 0, n, m));
    }
}
