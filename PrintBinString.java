public class PrintBinString {
    static void printBinString(int n, int lp, String str){
        //Base case
        if(n==0){
            System.out.println(str);
            return;
        }
        //kaam

        //for every place
        printBinString(n-1, 0, str+"0");
        //for place which have 0 in last place
        if(lp==0){
            printBinString(n-1, 1, str+"1");
        }
    }
    public static void main(String args[]){
        printBinString(4, 0, "");
    }
}
