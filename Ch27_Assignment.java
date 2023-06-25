public class Ch27_Assignment {
    //Q-1 find maximum number X, such that given string can be participated into X balanced substring.
    public static int maxBalanceSubstring(String str, int n){
        if(n==0){//string is empty
            return 0;
        }

        int l = 0, r = 0;
        int ans = 0;

        for(int i=0; i<n; i++){
            if(str.charAt(i) == 'L'){
                l++;
            }
            else if(str.charAt(i) == 'R'){
                r++;
            }

            if(l == r){
                ans++;
            }
        }
        return ans;
    }

    //Q-2 Kth Largest odd number in given range
    public static int kthLargest(int L, int R, int K){
        if((R - L)/2 < K){
            return 0;
        }
        int count = 0;
        while(R >= L){
            if(R % 2 != 0){//odd numbers
                count++;
            }
            if(count == K){
                break;
            }
            R--;
        }
        return R;
    }

    //Q-3 
    public static void main(String args[]){
        // String str = "LRRRRLLRLLRL";
        // System.out.println(maxBalanceSubstring(str, str.length()));

        System.out.println(kthLargest(-3, 3, 2));
    }
}
