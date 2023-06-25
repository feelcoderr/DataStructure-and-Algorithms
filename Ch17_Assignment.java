public class Ch17_Assignment {
    //Q-2 swap two number without auxilary variable
    public static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        System.out.println("a: "+ a + "b: "+ b);
    }

    //Q-3 Add and 1 to an integer using bit manipulation
    public static void add1(int x){
        //to get -x we do,          -x = ~x + 1
        //so, replacing x with ~x , -~x = x + 1
        System.out.println(-~x);
        return;
    }

    //Q-4 Convert uppercase character's into lower case
    public static void toLowercase(char ch){
        // a - A = 32 
        // so, A | 32 = a
        System.out.println((char)(ch & 32));

        /* 
        for(ch = 'A'; ch < 'Z'; ch++){
            System.out.print((char)(ch | 32) + " ");
        } 
        */
    }
    public static void main(String args[]){
        int x = 5;
        add1(x);

        int a = ' ';
        System.out.println(a);

        toLowercase('a');
    }
}
