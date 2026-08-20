class Solution {

    public static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int tRows = grid.length;
        int tCols = grid[0].length;

        int count = 0;
        boolean[][] vis = new boolean[tRows][tCols];
        for(int r = 0; r < tRows; r++){
            for(int c = 0; c < tCols; c++){
                if(!vis[r][c] && grid[r][c] == '1'){
                    bfs(r, c, tRows, tCols, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(int currRow, int currCol, int tRows, int tCols, boolean[][] vis, char[][] grid){
        vis[currRow][currCol] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(currRow, currCol));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int r = p.row;
            int c = p.col;
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < tRows && nc >= 0 && nc < tCols && !vis[nr][nc] && grid[nr][nc] == '1'){
                    queue.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
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
