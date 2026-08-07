class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    	
    	int totalSum = 0;
    	for(int num : nums) {
    		totalSum = totalSum + num;
    	}
    	if((totalSum - target) < 0 || (totalSum - target) % 2 != 0) {
    		return 0;
    	}
    	return findWays(nums, (totalSum - target)/2);
    	
    }

	private int findWays(int[] nums, int targetSum) {
		int n = nums.length;
		int[][] dp = new int[n][targetSum + 1];
		if(nums[0] == 0) {
			dp[0][0] = 2;
		}else {
			dp[0][0] = 1;
		}
		if(nums[0] != 0 && nums[0] <= targetSum) {
			dp[0][nums[0]] = 1;
		}
		for(int i = 1; i < n; i++) {
			for(int T = 0; T <= targetSum; T++) {
				int notTake = dp[i - 1][T];
				int take = 0;
				if(nums[i] <= T) {
					take = dp[i - 1][T - nums[i]];
				}
				dp[i][T] = notTake + take;
			}
		}
		return dp[n - 1][targetSum];
	}
}
