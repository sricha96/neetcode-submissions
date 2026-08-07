class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for(int i = 0; i < n; i++){
            newNums[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                for(int ind = i; ind <= j; ind++){
                    int coins = (newNums[i - 1] * newNums[ind] * newNums[j + 1]) + 
                        dp[i][ind - 1] + dp[ind + 1][j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[1][n];
    }
}
