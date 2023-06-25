public class SubsetBackTracking {
    static void subSets(String str, String ans, int i){
        //basecase
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
                return;
            }else{
                System.out.println(ans);
                return;
            }
        }
        //recursive call
        //choice is yes
        subSets(str, ans+ str.charAt(i), i+1);
        //choice is no
        subSets(str, ans, i+1);
    }
    public static void main(String args[]){
        String str="abc";
        String ans="";
        int i=0;
        subSets(str, ans, i);
    }
}
