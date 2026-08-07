class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        for(int i = 0; i < points.length; i++){
            int dis = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            queue.add(new Tuple(dis, points[i][0], points[i][1]));
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            Tuple t = queue.poll();
            int dis = t.dis;
            int x = t.x;
            int y = t.y;

            res[i] = new int[]{x, y};
        }
        return res;
    }
}

class Tuple{

    int dis;
    int x;
    int y;

    public Tuple(int dis, int x, int y){
        this.dis = dis;
        this.x = x;
        this.y = y;
    }
}
