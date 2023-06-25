public class Ch22_BackTracking {
    static boolean solvMaze(int maze[][]){
        int n=maze.length;
        int sol[][]= new int[n][n];
        if(solution(maze, 0, 0, sol)==false){
            System.out.println("Solution doesn't exist");
            return false;
        }
        printMaze(sol);
        return true;
    }

    static boolean solution(int maze[][], int x, int y, int sol[][]){
        //base case
        if(x==maze.length-1 && y==maze.length-1 && maze[x][y]==1){
            sol[x][y]=1;
            return true;
        }

        //kaam
        if(isSafe(maze, x, y)){
            if(sol[x][y]==1){
                return false;
            }
            sol[x][y]=1;

            //recursive call
            if(solution(maze, x+1, y, sol)){
                return true;
            }
            if(solution(maze,x, y+1, sol)){
                return true;
            }

            sol[x][y]=0;
            return false;
        }
        return false;
    }

    static boolean isSafe(int maze[][], int x, int y){
        return (0>=x && x<maze.length && 0>=y && y<maze.length && maze[x][y]==1);
    }

    static void printMaze(int maze[][]){
        for(int i=0 ; i<maze.length; i++){
            for(int j=0; j<maze.length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int maze[][]={ 
        {1,0,0,0},
        {1,1,0,1},
        {0,1,0,0},
        {1,1,1,1} };

        System.out.println(solvMaze(maze));
    }
}
