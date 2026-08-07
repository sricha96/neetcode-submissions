class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int carFleet = 0;
        int n = position.length;
        double[][] pair = new double[n][2];
        for(int i = 0; i < n; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b) -> Double.compare(b[0], a[0]));
        double[] distance = new double[n];
        for(int i = 0; i< n;i++){
            distance[i] = (target - pair[i][0])/pair[i][1];
            if(i >= 1 && distance[i] <= distance[i-1]){
                distance[i] = distance[i-1];
            }else{
                carFleet ++;
            }
        }
        return carFleet;
    }
}
