class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int max1 = maxAmount(Arrays.copyOfRange(nums,0,n-1));
        int max2 = maxAmount(Arrays.copyOfRange(nums,1,n));
        return Math.max(max1, max2);
    }

    public int maxAmount(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}
