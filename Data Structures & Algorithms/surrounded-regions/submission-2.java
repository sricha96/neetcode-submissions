class Solution {

    public static int[][] directions = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    public void solve(char[][] board) {
        
        int tRows = board.length;
        int tCols = board[0].length;

        bfs(board, tRows, tCols);

        for(int r = 0; r < tRows; r++){
            for(int c = 0; c < tCols; c++){
                if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                }else if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }

    }

    public void bfs(char[][] board, int tRows, int tCols){
        Queue<Pair> queue = new LinkedList<>();

        for(int r = 0; r < tRows; r++){
            for(int c = 0; c < tCols; c++){
                if(r == 0 || r == tRows - 1 || c == 0 || c == tCols - 1 && board[r][c] == 'O'){
                    queue.add(new Pair(r, c));
                }
            }
        }

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            if(board[row][col] == 'O'){
                board[row][col] = 'T';
                for(int[] dir : directions){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nr < tRows && nc >= 0 && nc < tCols){
                        queue.add(new Pair(nr, nc));
                    }
                }
            }
        }
    }
}

class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
