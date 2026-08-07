class Solution {

    public static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

    public int swimInWater(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;

        boolean[][] vis = new boolean[rl][cl];
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> a.height - b.height);
        queue.add(new Tuple(grid[0][0], 0, 0));
        vis[0][0] = true;
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int h = t.height;
            int r = t.row;
            int c = t.col;
            if(r == rl - 1 && c == cl - 1){
                return h;
            }
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < rl && nc >= 0 && nc < cl && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    queue.add(new Tuple(Math.max(h, grid[nr][nc]), nr, nc));
                }
            }
        }
        return rl * cl;
    }
}

class Tuple{

    int height;
    int row;
    int col;

    public Tuple(int height, int row, int col){
        this.height = height;
        this.row = row;
        this.col = col;
    }
}