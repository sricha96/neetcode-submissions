class Solution {

    public static int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int tRows = grid.length;
        int tCols = grid[0].length;

        boolean[][] vis = new boolean[tRows][tCols];
        int res = 0;
        for(int r = 0; r < tRows; r++){
            for(int c = 0; c < tCols; c++){
                if(!vis[r][c] && grid[r][c] == 1){
                    res = Math.max(res, bfs(r, c, tRows, tCols, vis, grid));
                }
            }
        }
        return res;
    }

    public int bfs(int currRow, int currCol, int tRows, int tCols, boolean[][] vis, int[][] grid){
        vis[currRow][currCol] = true;
        Queue<Pair> queue = new LinkedList<>();
        int res = 1;
        queue.add(new Pair(currRow, currCol));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < tRows && nc >= 0 && nc < tCols && !vis[nr][nc] && grid[nr][nc] == 1){
                    vis[nr][nc] = true;
                    queue.add(new Pair(nr, nc));
                    res++;
                }
            }
        }
        return res;
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
