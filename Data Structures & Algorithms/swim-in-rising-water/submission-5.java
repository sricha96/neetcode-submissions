class Solution {

    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int tRows = grid.length;
        int tCols = grid[0].length;
        
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> a.height - b.height);
        queue.add(new Tuple(0, 0, grid[0][0]));
        boolean[][] vis = new boolean[tRows][tCols];
        vis[0][0] = true;
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int row = t.row;
            int col = t.col;
            int height = t.height;

            if(row == tRows - 1 && col == tCols - 1){
                return height;
            }
            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < tRows && nc >= 0 && nc < tCols && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    queue.add(new Tuple(nr, nc, Math.max(height, grid[nr][nc])));
                }
            }
        }
        return -1;
    }
}

class Tuple{
    int row;
    int col;
    int height;

    Tuple(int row, int col, int height){
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
