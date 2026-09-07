class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                board[r][c] = '.';
            }
        }

        solveBoard(board, res, n, 0);
        return res;
    }

    public void solveBoard(char[][] board, List<List<String>> res, int n, int col){
        if(col == n){
            List<String> rows = new ArrayList<>();

            for(char[] row : board){
                rows.add(new String(row));
            }

            res.add(new ArrayList<>(rows));
            return;
        }

        for(int r = 0; r < n; r++){
            if(isSafe(board, r, col)){
                board[r][col] = 'Q';
                solveBoard(board, res, n, col + 1);
                board[r][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col){
        for(int r = 0; r < row; r++){
            if(board[r][col] == 'Q'){
                return false;
            }
        }
        for(int c = 0; c < col; c++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }

        for(int r = row, c = col; r >= 0 && c >= 0; r--, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        for(int r = row, c = col; r < board.length && c >= 0; r++, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
