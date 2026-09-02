class Solution {

    public List<List<String>> solveNQueens(int n) {

        // Stores all valid N-Queens boards
        List<List<String>> res = new ArrayList<>();

        // Create n x n chess board
        char[][] board = new char[n][n];

        // Initially fill the entire board with '.'
        // '.' means the cell is empty
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                board[r][c] = '.';
            }
        }

        // Start backtracking from column 0
        solve(board, res, n, 0);

        return res;
    }


    public void solve(char[][] board, List<List<String>> res,
                      int n, int col){

        // If we placed a queen in every column,
        // we found one valid solution
        if(col == n){

            List<String> path = new ArrayList<>();

            // Convert each char[] row into a String
            for(char[] row : board){
                path.add(new String(row));
            }

            // Store a copy of this valid board
            res.add(new ArrayList<>(path));

            return;
        }


        // Try placing a queen in every row
        // of the current column
        for(int row = 0; row < n; row++){

            // Place queen only if this position is safe
            if(isSafe(board, row, col, n)){

                // Choose: place the queen
                board[row][col] = 'Q';

                // Move to the next column
                solve(board, res, n, col + 1);

                // Backtrack:
                // remove the queen and try another row
                board[row][col] = '.';
            }
        }
    }


    public boolean isSafe(char[][] board, int row, int col, int n){

        // Check the entire current column
        // to make sure no queen already exists
        for(int r = 0; r < n; r++) {

            if(board[r][col] == 'Q') {
                return false;
            }
        }


        // Check the entire current row
        // to make sure no queen already exists
        for(int c = 0; c < n; c++) {

            if(board[row][c] == 'Q') {
                return false;
            }
        }


        // Check upper-left diagonal
        // Move: row--, col--
        for(int r = row, c = col;
            r >= 0 && c >= 0;
            r--, c--) {

            if(board[r][c] == 'Q') {
                return false;
            }
        }


        // Check lower-left diagonal
        // Move: row++, col--
        for(int r = row, c = col;
            r < n && c >= 0;
            r++, c--) {

            if(board[r][c] == 'Q') {
                return false;
            }
        }


        // No queen found in the same row,
        // column, or diagonal
        return true;
    }
}