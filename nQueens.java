public class nQueens {
    static boolean isSafe(char board[][], int row, int col){
        //Vartically up
        for(int i=row; i>=0 ; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //Diagonally left
        for(int i=row,j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //Diagonally right
        for(int i=row,j=col; i>=0 && j<board.length; i--, j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    static void nQueens(char board[][], int row){
        //BaseCase
        if(row==board.length){
            printBoard(board);
            return;
        }
        //check posible ways
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                nQueens(board,row+1); //recursive call
                board[row][j]='x'; //backtracking step
            }
        }
        
    }
    static void printBoard(char board[][]){
        System.out.println("<----------------ChessBoard--------------->");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int n=4;
        char board[][] = new char[n][n];
        
        //initialize
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j]='x';
            }
        }

        nQueens(board, 0);
    }
}


