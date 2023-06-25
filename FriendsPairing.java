public class FriendsPairing {
    static int findWays(int n){
        if(n==0 || n==1){
            return 1;
        }
        // Number of ways to remain single
        int SingleWays= 1* findWays(n-1);
        //Number of ways to make pairs
        int PairsWays= (n-1) * findWays(n-2);

        return SingleWays+PairsWays;
    }
    public static void main(String[] args){
        System.out.println(findWays(4));
    }
}
