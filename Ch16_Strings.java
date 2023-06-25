import java.util.Arrays;

public class Ch16_Strings {
    //find sortest path from origin to "WNNNSWSE"
    public static float sortestPath(String directions){
        int x=0, y=0;
        for(int i=0; i<directions.length(); i++){
            switch(directions.charAt(i)){
                case 'E':
                x++;
                break;
                
                case 'W':
                x--;
                break;

                case 'N':
                y++;
                break;

                case 'S':
                y--;
                break;

                default:
                break;
            }
        }
        float sortestPath=(float)Math.sqrt(x*x + y*y);
        return sortestPath;
    }
    //lecsicographycally Greater fruits
    public static String getLargestString (String fruits[]){
        String largest=fruits[0];

        for(int i=1; i<fruits.length; i++){
            if(fruits[i].compareToIgnoreCase(largest)>0){
                largest=fruits[i];
            }
        }

        return largest;
    }
    //Convert first latters of words into uppercase
    public static String convertUpperCase(String str){
        StringBuilder sb= new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i=1; i<str.length(); i++){
            //after every space new word will start
            if(str.charAt(i-1)==' '){
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        String ans=sb.toString();
        return ans;
    }

    //String Compression
    public static String compress(String str){
        StringBuilder sb= new StringBuilder();
        Integer count;
        for(int i=0; i<str.length(); i++){
            count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            
            sb.append(str.charAt(i));
            if(count>1)
            sb.append(count.toString());
        }
        return sb.toString();
    }
    //Q-1 Find how many times vowels come in strings
    public static int countVowels(String str){
        String vowelStr= "aeiou";
        int count=0;
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<vowelStr.length(); j++){
                if(str.charAt(i)==vowelStr.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
    //Q-2 .equals() function use
    public static void str() {
        String str="ShradhaDidi";
        String str1="ApnaCollege";
        String str2="ShradhaDidi";
        System.out.println(str.equals(str1) +" "+str.equals(str2));
    }

    //Q-3 .replace function use
    public static void equalFunc() {
        String str="ApnaCollege".replace("l","");
        System.out.println(str);
    }
    //Q-4 Determine two strings are anagrams of each other or not
    public static boolean isAnagrams(String str, String str2){
        
        if(str.length()!=str2.length()){
            return false;
        }
        
        //convert string in to array
        char chArr[]=str.toCharArray();
        char chArr2[]=str2.toCharArray();

        //sort this arrays
        Arrays.sort(chArr);
        Arrays.sort(chArr2);

        boolean result = Arrays.equals(chArr, chArr2);
        return result;
    }

    public static void main(String args[]){
        // String directions= "WNNENE";
        // System.out.println(sortestPath(directions));

        // String fruits[]={"mango","banana","apple","pineapple","orange"};
        // System.out.println(getLargestString(fruits));

        // String str="hello! i am yogesh s";
        // System.out.println(convertUpperCase(str));

        // String str="cccc";
        // System.out.println(compress(str));

        //String str= "aidfnioojo=e";
        //System.out.println(countVowels(str));
        //str();
        //equalFunc();
        String str="race",str2="care";
        System.out.println(isAnagrams(str, str2));
    }
}
