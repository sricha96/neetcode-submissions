class Solution {
    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int tRows = grid.length;
        int tCols = grid[0].length;

        int fresh = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int r = 0; r < tRows; r++){
            for(int c = 0; c < tCols; c++){
                if(grid[r][c] == 2){
                    queue.add(new Pair(r, c));
                }
                if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        return bfs(queue, tRows, tCols, grid, fresh);
    }

    public int bfs(Queue<Pair> queue, int tRows, int tCols, int[][] grid, int fresh){
        int minTime = 0;
        while(!queue.isEmpty() && fresh != 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair p = queue.poll();
                int row = p.row;
                int col = p.col;
                for(int[] dir : directions){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nr < tRows && nc >= 0 && nc < tCols && grid[nr][nc] == 1){
                        queue.add(new Pair(nr, nc));
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            minTime++;
        }
        return fresh == 0 ? minTime : -1;
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