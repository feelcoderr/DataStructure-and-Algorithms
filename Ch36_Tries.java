
public class Ch36_Tries {
    static class Node{
        Node children[] = new Node[26]; // 'a' to 'z'
        boolean eow = false; // endOfWord
        public Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    //store word in tries
    public static void insert(String word){ // O(L) L-length of word
        Node curr = root;

        for(int level = 0; level<word.length(); level++){//
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // at the last char of word
    }
    //Search word in Tries
    public static boolean search(String key){
        Node curr = root;
        for(int level = 0; level < key.length(); level++){
            int idx = key.charAt(level)- 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    //Word Break Problem
    public static boolean wordBreak(String key){
        //base case
        if(key.length() == 0) return true;

        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        String word[] = {"the", "a", "there", "their", "any", "thee", "tree", "is"};
        for(int i=0; i<word.length; i++){
            insert(word[i]);
        }

        //System.out.println(search("thor"));

        String key = "isthereatree";// is there a tree
        System.out.println(wordBreak(key));
    }
}
