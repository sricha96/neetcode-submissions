class Solution {

    public static int INF = 2147483647;
    public static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        
        int tRows = grid.length;
        int tCols = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        for(int r = 0; r < tRows; r++){
            for(int c = 0; c < tCols; c++){
                if(grid[r][c] == 0){
                    queue.add(new Pair(r, c));
                }
            }
        }
        bfs(queue, tRows, tCols, grid);
    }

    public void bfs(Queue<Pair> queue, int tRows, int tCols, int[][] grid){
        boolean[][] vis = new boolean[tRows][tCols];
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair p = queue.poll();
                int row = p.row;
                int col = p.col;
                for(int[] dir : directions){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nr < tRows && nc >= 0 && nc < tCols && grid[nr][nc] == INF){
                        queue.add(new Pair(nr, nc));
                        grid[nr][nc] = grid[row][col] + 1;
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