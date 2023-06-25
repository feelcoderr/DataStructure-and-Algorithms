public class Stocks {
    static int profit(int price[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit= 0;

        for(int i=0; i<price.length; i++){
            if(buyPrice<price[i]){
                int profit= price[i]-buyPrice;
                maxProfit= Math.max(profit, maxProfit);
            }else{
                buyPrice=price[i];
            }
        }
        return maxProfit;
    }
    public static void main(String args[]){
        int price[]={3,2,6,5,0,3};
        System.out.println(profit(price));
    }
}
