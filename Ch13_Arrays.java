import java.util.Arrays;
public class Ch13_Arrays {
    //Q-1 Return true if any velue appears twice in array
    public static boolean isTwice(int arr[]){
        if(arr.length<2){
            return false;
        }
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++){
            if(arr[i]==arr[i-1]){
                return true;
            }
        }
        return false;
    }

    //Q-2 find target in sorted rotated array
    public static int findTarget(int arr[], int target){
        int minIdx= minSearch(arr);
        if(arr[minIdx]<=target && target<= arr[arr.length-1]){
            return search(arr, minIdx, arr.length-1, target);
        }else{
            return search(arr, 0, minIdx, target);
        }
        
    }
    
    public static int minSearch(int arr[]){
        int si=0, ei=arr.length-1;

        while(si<=ei){
            int mid=si+(ei-si)/2;

            if(mid>0 && arr[mid-1]>arr[mid]){
                return mid;
            }

            if(arr[si]<=arr[mid] && arr[mid]>arr[ei]){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        return 0;
    }
    public static int search(int arr[], int si, int ei, int target){
        while(si<=ei){
            int mid=si+(ei-si)/2;

            if(arr[mid]==target){
                return mid;
            }

            if(arr[mid]>target){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return -1;
    }
    //Q-3 return maximum profit you can achive
    public static int maxProfit(int prices[]){
        if(prices.length<2){
            return 0;
        }
        int buyPrice=prices[0];
        int maxProfit=0;

        for(int i=1; i<prices.length; i++){
            int profit=prices[i]-buyPrice;
            
            maxProfit=Math.max(maxProfit, profit);
            buyPrice=Math.min(buyPrice, prices[i]);
        }

        return maxProfit;
    }
    //Q-4 Trapping water in bricks
    public static int maxTrapingWater(int height[]){

        //corner cases
        if(height.length<3)return 0;

        int n=height.length;
        int rightMaxHeight[]= new int [n];
        int leftMaxHeight[]= new int[n];

        leftMaxHeight[0]=height[0];
        int maxLeft=leftMaxHeight[0];
        for(int i=1; i<n-1; i++){
            maxLeft=Math.max(maxLeft, height[i]);
            leftMaxHeight[i]=maxLeft;
        }

        rightMaxHeight[n-1]=height[n-1];
        int maxRight=rightMaxHeight[n-1];
        for(int i=n-2; i>=0; i--){
            maxRight=Math.max(maxRight, height[i]);
            rightMaxHeight[i]=maxRight;
        }
        
        int totalWater=0;
        for(int i=0; i<n-1; i++){
            //water height= minimum of (leftmaxheight and rightmaxHight)
            int waterLevel= Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            //max water can store on bricks is = water hight-bricks height
            int currWater=waterLevel-height[i];
            totalWater+=currWater;
        }
        return totalWater;
    }
    //Q-5 return all triplates of i!=j j!=k k!=i and nums[i]+nums[j]+nums[k]==0
    public static void findTriplates(int nums[], int triplates[][]){
        int idx=0;
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                for(int k=j+1; k<nums.length-1; k++){
                    // if(nums[i]!=nums[j] && nums[j]!=nums[k] )
                    if(nums[i]+nums[j]+nums[k]==0){
                        triplates[idx][0]=nums[i];
                        triplates[idx][1]=nums[j];
                        triplates[idx][2]=nums[k];
                        idx++;
                    }
                }
            }
        }
        return;
    }
    public static void main(String args[]){
        //Q-1
        // int arr[]={1,2,3,8};
        // System.out.println(isTwice(arr));

        //Q-2
        // int arr[]={4, 5, 6, 7, 0, 1, 2};
        // System.out.println(findTarget(arr, 4));

        //Q-3
        // int prices[]={7, 6, 3, 3, 2,  1};
        // System.out.println(maxProfit(prices));

        //Q-4
        // int height[]={4, 2, 0, 3, 2, 5};
        // System.out.println(maxTrapingWater(height));

        //Q-5
        int nums[]={-1, 0,  1, 2, -1, -4};
        int triplates[][]= new int[nums.length][3];
        //print triplates
        for(int i=0; i<triplates.length-1; i++){
            for(int j=0; j<3; j++){
                System.out.print(triplates[i][j]+", ");
            }
            System.out.println();
        }
    }
}
