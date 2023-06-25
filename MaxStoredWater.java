import java.util.*;
public class MaxStoredWater {
    static int storedWater(ArrayList<Integer> height){
        int maxWater=0;
        //brute force O(n^2)

        // for(int i=0; i<height.size(); i++){
        //     for(int j=i+1; j<height.size(); j++){
        //         //water=height * width
        //         int currWater=Math.min(height.get(i),height.get(j))*(j-i);

        //         maxWater=Math.max(maxWater, currWater);
        //     }
        // }

        //2 Pointer approch O(n)
        int lp=0; // Left pointer
        int rp=height.size()-1;  // right pointer

        while(lp<rp){
            //water= height * width
            int ht=Math.min(height.get(lp),height.get(rp));//height of water
            int wd=rp-lp; //width of water
            int water=ht*wd;

            maxWater= Math.max(water,maxWater);

            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String args[]){
        ArrayList<Integer> height= new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storedWater(height));
    }
}
