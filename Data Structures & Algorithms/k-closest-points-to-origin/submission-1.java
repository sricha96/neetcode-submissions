class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        for(int[] point : points){
            int distance = (point[0] * point[0]) + (point[1] * point[1]);
            queue.add(new Tuple(point[0], point[1], distance));
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            Tuple t = queue.poll();
            res[i] = new int[]{t.x, t.y};
        }
        return res;
    }
}

class Tuple{
    int x;
    int y;
    int dis;

    Tuple(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}