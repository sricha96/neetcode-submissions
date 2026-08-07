class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                board[r][c] = '.';
            }
        }

        solve(board, res, n, 0);
        return res;
    }

    public void solve(char[][] board, List<List<String>> res, int n, int col){
        if(col == n){
            List<String> path = new ArrayList<>();
            for(char[] row : board){
                path.add(new String(row));
            }
            res.add(new ArrayList<>(path));
            return;
        }

        for(int row = 0; row < n; row++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                solve(board, res, n, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col, int n){
        for(int r = 0; r < n; r++) {
        	if(board[r][col] == 'Q') {
        		return false;
        	}
        }
        
        for(int c = 0; c < n; c++) {
        	if(board[row][c] == 'Q') {
        		return false;
        	}
        }
        
        for(int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
        	if(board[r][c] == 'Q') {
        		return false;
        	}
        }
        
        for(int r = row, c = col; r < n && c >= 0; r++, c--) {
        	if(board[r][c] == 'Q') {
        		return false;
        	}
        }
        return true;
    }
}
