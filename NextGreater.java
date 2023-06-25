import java.util.Stack;
public class NextGreater {
    public static void findNextGreater(int arr[], int nextGreater[]){
        //step-1 make stack of greater elments idx
        Stack<Integer> s= new Stack<>();
        s.push(arr.length-1);
        nextGreater[arr.length-1]=-1;

        //step-2 run loon from n to 0 for arr
        for(int i=arr.length-2; i>=0; i--){

            //pop all small elements than arr[i] from stack
            while(!s.isEmpty() && arr[i]>arr[s.peek()]){
                s.pop();
            }

            //if no elements arr greater than stack nextGreater[i]= -1
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }
            //else the top of stack will be next greater of i
            else{
                nextGreater[i]=arr[s.peek()];
            }
            //add i in stack of idx of greater elements
            s.push(i);
        }
    }
    public static void main(String args[]){
        int arr[]={6,8,0,1,3};
        int nextGreater[]= new int[arr.length];

        findNextGreater(arr, nextGreater);
        for(int i=0; i<arr.length; i++){
            System.out.print(nextGreater[i]+" ");
        }
    }
}
