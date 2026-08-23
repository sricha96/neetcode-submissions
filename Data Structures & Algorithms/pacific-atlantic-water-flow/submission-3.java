class Solution {

    public static int[][] directions = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int tRows = heights.length;
        int tCols = heights[0].length;

        boolean[][] pacVis = new boolean[tRows][tCols];
        boolean[][] atVis = new boolean[tRows][tCols];

        Queue<Pair> pacQueue = new LinkedList<>();
        Queue<Pair> atQueue = new LinkedList<>();

        for(int r = 0; r < tRows; r++){
            pacQueue.add(new Pair(r, 0));
            atQueue.add(new Pair(r, tCols - 1));
        }

        for(int c = 0; c < tCols; c++){
            pacQueue.add(new Pair(0, c));
            atQueue.add(new Pair(tRows - 1, c));
        }

        bfs(pacQueue, pacVis, tRows, tCols, heights);
        bfs(atQueue, atVis, tRows, tCols, heights);

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < tRows; r++){
            for(int c = 0; c < tCols; c++){
                if(pacVis[r][c] && atVis[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    public void bfs(Queue<Pair> queue, boolean[][] vis, int tRows, int tCols, int[][] heights){
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            vis[row][col] = true;

            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < tRows && nc >= 0 && nc < tCols && !vis[nr][nc] && heights[nr][nc] >= heights[row][col]){
                    queue.add(new Pair(nr, nc));
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