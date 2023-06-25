import java.util.*;
import java.util.Stack;
public class StockSpan {
    public static void calculateSpan(int stock[], int span[]){
        if(stock.length==0){
            return;
        }
        Stack<Integer> s= new Stack<>();
        span[0]=1;
        s.push(0);

        for(int i=1; i<stock.length; i++){
            int currPrice=stock[i];
            while(!s.isEmpty() && currPrice > stock[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i]=i+1; //if there is no prevHigh, span = currIdx+ 1
            }else{
                int prevHigh=s.peek();
                span[i]= i-prevHigh;// span= currIdx-prevHighIdx
            }
            s.push(i);
        }
    }
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    public static void main(String args[]){
        int stock[]={100,80,60,70,60,85,100};
        int span[]= new int [stock.length];

        calculateSpan(stock, span);
        printArr(span);
    }
}
