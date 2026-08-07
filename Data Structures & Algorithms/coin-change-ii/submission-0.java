class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int T = 0 ; T <= amount; T++){
            if(T % coins[0] == 0){
                dp[0][T] = 1;
            }else{
                dp[0][T] = 0;
            }
        }
        for(int i = 1; i < n; i++){
            for(int T = 0; T <= amount; T++){
                int notTake = 0 + dp[i - 1][T];
                int take = 0;
                if(coins[i] <= T){
                    take = dp[i][T - coins[i]];
                }
                dp[i][T] = notTake + take;
            }
        }
        return dp[n - 1][amount];
    }
}
