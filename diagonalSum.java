import java.util.*;

public class diagonalSum {
    public static void dSumPrint(int matrix[][]){
        int pSum= 0;
        int sSum= 0;

        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(i==j){
        //             pSum+=matrix[i][j];
        //         }
        //         else if(i+j==matrix.length-1){
        //             sSum+=matrix[i][j];
        //         }
        //     }
        // }

        for(int i=0; i<matrix.length; i++){
            //pd
            pSum+=matrix[i][i];

            //sd
            if(i!=matrix.length-i-1){
                sSum+=matrix[i][matrix.length-i-1];
            }
        }
        System.out.println(pSum+sSum);
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        int matrix[][]= {{1,2,3},
                         {5,6,7},
                         {9,10,11}};
        dSumPrint(matrix);
    }
}
