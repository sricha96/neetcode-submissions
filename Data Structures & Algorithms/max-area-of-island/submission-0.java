class Solution {

    public static int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] vis = new boolean[r][c];
        int maxArea = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    maxArea = Math.max(maxArea, bfs(grid, i, j, r, c, vis));
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid, int row, int col, int r, int c, boolean[][] vis){
        vis[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int res = 1;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int pr = p.first;
            int pc = p.second;
            for(int[] dir : directions){
                int nr = dir[0];
                int nc = dir[1];
                int npr = pr + nr;
                int npc = pc + nc;
                if(npr >= 0 && npr < r && npc >= 0 && npc < c && 
                    !vis[npr][npc] && grid[npr][npc] == 1){
                        vis[npr][npc] = true;
                        queue.add(new Pair(npr, npc));
                        res++;
                    }
            }

        }
        return res;
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
