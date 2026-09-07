class Solution {
    public boolean exist(char[][] board, String word) {

        int tRows = board.length;
        int tCols = board[0].length;

        boolean[][] vis = new boolean[tRows][tCols];
        for(int r = 0; r < tRows; r++){
            for(int c = 0; c < tCols; c++){
                if(wordExist(board, r, c, tRows, tCols, vis, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordExist(char[][] board, int r, int c, int tRows, int tCols, boolean[][] vis, String word, int i){
        if(i == word.length()){
            return true;
        }
        if(r < 0 || r >= tRows || c < 0 || c >= tCols || vis[r][c] || board[r][c] != word.charAt(i)){
            return false;
        }
        vis[r][c] = true;
        boolean found = wordExist(board, r + 1, c, tRows, tCols, vis, word, i + 1) || 
        wordExist(board, r - 1, c, tRows, tCols, vis, word, i + 1) || 
        wordExist(board, r, c + 1, tRows, tCols, vis, word, i + 1) ||
        wordExist(board, r, c - 1, tRows, tCols, vis, word, i + 1);
        vis[r][c] = false;

        return found;
    }
}
