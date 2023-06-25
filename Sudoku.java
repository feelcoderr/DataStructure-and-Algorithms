public class Sudoku {
    static boolean sudokuSolver(int sudoku[][], int row, int col){
        //base case
        if(row==9){
            printSudoku(sudoku);
            return true;
        }

        //kaam
        //calculate next row and next col
        int nextRow=row, nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }
        //when place is already full
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        //placed apropriate digit on place and call for next place
        for(int digit=1; digit<=9; digit++){
            if(isSafe(sudoku,row, col, digit)){
                sudoku[row][col]=digit;
                //recursive call
                if(sudokuSolver(sudoku,nextRow, nextCol)){
                    return true;
                }
                //backtracking
                sudoku[row][col]=0;
            }
        }
        return false;
    }
    static boolean isSafe(int sudoku[][], int row, int col, int digit){
        //in same row
        for(int i=0; i<9; i++){
            if(sudoku[row][i]==digit){
                return false;
            }
        }
        // in same col
        for(int i=0; i<9; i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        //in same grid
        int sr=(row/3)*3, sc=(col/3)*3;
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j]==digit){
                return false;
            }
            }
        }
        return true;
    }

    // to print sudoku
    static void printSudoku(int sudoku[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int sudoku[][]={
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
        };
        System.out.println(sudokuSolver(sudoku,0,0));
    }
}
