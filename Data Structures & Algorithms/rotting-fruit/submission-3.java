class Solution {

    public static int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int orangesRotting(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int r = 0; r < rowLen; r++){
            for(int c = 0; c < colLen; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    queue.add(new Pair(r, c));
                }
            }
        }
        return bfs(grid, queue, rowLen, colLen, fresh, time);
    }

    public int bfs(int[][] grid, Queue<Pair> queue, int rowLen, int colLen, int fresh, int time){
        while(fresh > 0 && !queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair p = queue.poll();
                int pr = p.first;
                int pc = p.second;
                for(int[] dir : directions){
                    int newRow = pr + dir[0];
                    int newCol = pc + dir[1];
                    if(newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen 
                        && grid[newRow][newCol] == 1){
                            grid[newRow][newCol] = 2;
                            queue.add(new Pair(newRow, newCol));
                            fresh--;
                        }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
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
