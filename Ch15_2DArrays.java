import java.util.*;
public class Ch15_2DArrays {

    //Q-1 Find how many times 7 comes in 2D array
    public static void numRepeat(int arr[][],int key){
        int count=0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==key){
                    count++;
                }
            }
        }
        System.out.println(count);
        return;
    }

    //Q-2 Sum of numbers in second row
    public static void sumOfRow(int arr[][]){
        int sum=0;
        for(int j=0; j<arr[0].length; j++){
            sum+=arr[1][j];
        }
        System.out.println(sum);
    }

    //Q-3 Transpose of matrix
    public static void transpose(int arr[][]){
        int transposeArr[][]= new int [arr[0].length][arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                transposeArr[j][i]=arr[i][j];
            }
        }
        for(int i=0; i<arr[0].length; i++){
            for(int j=0; j<arr.length; j++){
                System.out.print(transposeArr[i][j]);
            }
            System.out.println();
        }
    }
    public static class idx{
        int row;
        int col;
    }

    //Staircase search
    public static idx stairCase(int arr[][], int key){
        idx i= new idx();
        i.row=arr.length-1;
        i.col=0;

        while(i.row>=0 && i.col<=arr[0].length-1){
            if(arr[i.row][i.col]==key){
                return i;
            }

            if(arr[i.row][i.col]>key){
                i.row--;
            }else{
                i.col++;
            }
        }
        
        return i;
    }
    //*** Spiral matrix
    public static void spiralPrint(int arr[][]){
        int startRow=0;
        int startCol=0;
        int endRow=arr.length-1;
        int endCol=arr[0].length-1;

        while(startRow<=endRow && startCol<=endCol){
            if(startRow==endRow && startCol==endCol){
                System.out.println(arr[startRow][startCol]);
                return;
            }
            //top
            for(int j=startCol; j<endCol; j++){
                System.out.print(arr[startRow][j]+" ");
            }
            //Right
            for(int i=startRow; i<endRow; i++){
                System.out.print(arr[i][endCol]+" ");
            }
            //bottom
            for(int j=endCol; j>startCol; j--){
                System.out.print(arr[endRow][j]+" ");
            }
            //left
            for(int i=endRow; i>startRow; i--){
                System.out.print(arr[i][startCol]+" ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }
    //**Diagonal Sum
    public static int diagonalSum(int matrix[][]){
        int sum=0;

        for(int i=0; i<matrix.length; i++){
            //primary diagonal Sum
            sum+=matrix[i][i];

            //secondary diagonal sum
            if(i!=matrix.length-1-i)
                sum+=matrix[i][matrix.length-1-i]; //i+j=n-1
        }
        
        return sum;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        int arr[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        //numRepeat(arr, 9);
        //sumOfRow(arr);
        //transpose(arr);

        // idx i= stairCase(arr, 40);
        // System.out.println(i.row+", "+i.col);

        //spiralPrint(arr);
        System.out.println(diagonalSum(arr));
    }
}
