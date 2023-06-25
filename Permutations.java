public class Permutations {
    static void findPermutation(String str, String ans){
        //Base Case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //Recursion O(n*n!)
        for(int i=0; i<str.length(); i++){
            char curr= str.charAt(i);
            //"abcde" => "ab" + "de"
            String newStr= str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, ans+curr);
        }
    }
    public static void main(String args[]){
        String str="abc";
        String ans="";
        findPermutation(str, ans);
    }
}
