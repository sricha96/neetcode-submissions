class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int count = 0;
        for(int num : nums){
            count = count + num;
            maxSum = Math.max(maxSum, count);
            if(count < 0){
                count = 0;
            }
        }
        return maxSum;
    }
}
