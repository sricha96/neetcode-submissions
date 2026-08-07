class Solution {

    public static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        
        for(int row = 0; row < rowLen; row++){
            for(int col = 0; col < colLen; col++){
                if(grid[row][col] == INF){
                    grid[row][col] = bfs(grid, row, col, rowLen, colLen);
                }
            }
        }
        
    }

    public int bfs(int[][] grid, int row, int col, int rowLen, int colLen){
        boolean[][] vis = new boolean[rowLen][colLen];
        vis[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
            Pair curr = queue.poll();
            int currRow = curr.first;
            int currCol = curr.second;
            if(grid[currRow][currCol] == 0){
                return steps;
            }
            for(int[] dir : directions){
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                
                if(newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen 
                    && !vis[newRow][newCol] && grid[newRow][newCol] != -1){
                        vis[newRow][newCol] = true;
                        queue.add(new Pair(newRow, newCol));
                    }
            }
            }
            steps++;
        }
        return INF;
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
