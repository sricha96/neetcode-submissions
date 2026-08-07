class Solution {
    public static int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    public void solve(char[][] board) {
        int rowlen = board.length;
        int collen = board[0].length;

        bfs(board, rowlen, collen);
        
        for(int r = 0; r < rowlen; r++){
            for(int c = 0; c < collen; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }else if(board[r][c] == 'N'){
                    board[r][c] = 'O';
                }
            }
        }
        
    }

    public void bfs(char[][] board, int rowlen, int collen){
        Queue<Pair> queue = new LinkedList<>();
        for(int r = 0; r < rowlen; r++){
            for(int c = 0; c < collen; c++){
                if(r == 0 || r == rowlen-1 
                    || c == 0 || c == collen-1 
                    && board[r][c] == 'O'){
                    queue.add(new Pair(r,c));
                }
            }
        }

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int pr = p.first;
            int pc = p.second;
            if(board[pr][pc] == 'O'){
                board[pr][pc] = 'N';
                for(int[] dir : directions){
                    int nr = pr + dir[0];
                    int nc = pc + dir[1];
                    if(nr >= 0 && nr < rowlen && nc >= 0 && nc < collen){
                        queue.add(new Pair(nr, nc));
                    }
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
