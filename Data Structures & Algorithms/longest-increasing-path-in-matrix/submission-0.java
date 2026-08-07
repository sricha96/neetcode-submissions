class Solution {

    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int res = 0;
        for(int r = 0; r < rowLength; r++){
            for(int c = 0; c < colLength; c++){
                res = Math.max(res, dfs(matrix, r, c, Integer.MIN_VALUE));
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int r, int c, int prevValue){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        if(r < 0 || r >= rowLength || c < 0 || c >= colLength || matrix[r][c] <= prevValue){
            return 0;
        }
        int res = 1;
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            res = Math.max(res, 1 + dfs(matrix, nr, nc, matrix[r][c]));
        }
        return res;
    }
}
