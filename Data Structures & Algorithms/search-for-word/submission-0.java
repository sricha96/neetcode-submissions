class Solution {
    int row;
    int col;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        boolean[][] vis = new boolean[row][col];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(solve(board, r, c, vis, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, int r, int c, boolean[][] vis, String word, int i){
        if(i == word.length()){
            return true;
        }
        if(r < 0 || r >= row || c < 0 || c >= col || board[r][c] != word.charAt(i) || vis[r][c]){
            return false;
        }
        vis[r][c] = true;
        boolean res = solve(board, r + 1, c, vis, word, i + 1) || 
            solve(board, r - 1, c, vis, word, i + 1) || 
            solve(board, r, c + 1, vis, word, i + 1) || 
            solve(board, r, c - 1, vis, word, i + 1);
        vis[r][c] = false;

        return res;
    }
}
