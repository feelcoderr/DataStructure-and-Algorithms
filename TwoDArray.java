import java.util.*;

public class TwoDArray {

    //Largest element in 2D Array
    public static void MaxNumber(int matrix[][]){
        int maxNum= Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                maxNum=Math.max(maxNum,matrix[i][j]);
            }
        }
        System.out.println(maxNum);
    }

    //Search key in 2D Array
    public static boolean SearchKey(int matrix[][],int key){
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==key){
                    System.out.print("Key Found at ("+ i +","+j+")");
                    return true;
                }
            }
        }
        System.out.print("Key not found");
        return false;
    }
    //Print 2D Array
    public static void PrintArr(int matrix[][]){
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        //int m= sc.nextInt();
        //int n= sc.nextInt();
        //int matrix[][]= new int[m][n];
        int matrix[][]= {{1,2,3,4},
                         {5,6,7,8},
                         {9,10,11,12},
                         {13,14,15,16}};

        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         matrix[i][j]= sc.nextInt();
        //     }
        // }

        PrintArr(matrix);
        //SearchKey(matrix, 3);
        //MaxNumber(matrix);

    }
}
