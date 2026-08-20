class Solution {

    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int count = 0;
        for(int row = 0; row < r; row++){
            for(int col = 0; col < c; col++){
                if(!visited[row][col] && grid[row][col] == '1'){
                    
                    bfs(grid, row, col, visited, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int row, int col, 
        boolean[][] visited, int r, int c){
        visited[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int pr = p.r;
            int pc = p.c;
            for(int[] dir : directions){
                int nr = dir[0];
                int nc = dir[1];
                    int npr = pr + nr;
                    int npc = pc + nc;
                    if(npc >= 0 && npc < c && npr >= 0 && npr < r && !visited[npr][npc] && grid[npr][npc] == '1'){
                        visited[npr][npc] = true;
                        queue.add(new Pair(npr, npc));
                    }
            }
        }
    }
}

class Pair{
    int r;
    int c;
    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
