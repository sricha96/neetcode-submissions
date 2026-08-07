class Solution {

    public static int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowLen = heights.length;
        int colLen = heights[0].length;
        Queue<Pair> pacQueue = new LinkedList<>();
        Queue<Pair> atQueue = new LinkedList<>();

        boolean[][] pac = new boolean[rowLen][colLen];
        boolean[][] at = new boolean[rowLen][colLen];

        for(int r = 0; r < rowLen; r++){
            pacQueue.add(new Pair(r, 0));
            atQueue.add(new Pair(r, colLen - 1));
        }
        for(int c = 0; c < colLen; c++){
            pacQueue.add(new Pair(0, c));
            atQueue.add(new Pair(rowLen - 1, c));
        }

        bfs(heights, pacQueue, pac, rowLen, colLen);
        bfs(heights, atQueue, at, rowLen, colLen);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < rowLen; i ++){
            for(int j = 0; j < colLen; j++){
                if(pac[i][j] && at[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void bfs(int[][] heights, Queue<Pair> queue, boolean[][] vis, int rowLen, int colLen){
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int currRow = curr.first;
            int currCol = curr.second;
            vis[currRow][currCol] = true;
            for(int[] dir : directions){
                int nr = currRow + dir[0];
                int nc = currCol + dir[1];
                if(nr >= 0 && nr < rowLen && nc >= 0 && nc < colLen 
                    && !vis[nr][nc] 
                    && heights[nr][nc] >= heights[currRow][currCol]){
                        queue.add(new Pair(nr,nc));
                    }
            }

        }
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
