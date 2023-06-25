import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

public class TilingProblem {
    static int tilingProb(int n){
        if(n==0 || n==1){
            return 1;
        }
        //vertical
        int fnm1= tilingProb(n-1);
        //horizontal
        int fnm2= tilingProb(n-2);
        //total ways
        int totWay= fnm1 + fnm2;

        return totWay;
    }
    public static void main(String args[]){
        System.out.println(tilingProb(4));
    }
}
