class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int leftProduct = 0;
        int rightProduct = 0;
        for(int i = 0; i < nums.length; i++){
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[nums.length - 1 - i];
            res = Math.max(res, Math.max(leftProduct, rightProduct));
        }
        return res;
    }
}
