class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int r = m;

        while(l <= r){
            int partition1 = l + (r - l)/2;

            int partition2 = (m + n + 1)/2 - partition1;

            int nums1Left = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int nums1Right = partition1 == m ? Integer.MAX_VALUE : nums1[partition1];

            int nums2Left = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int nums2Right = partition2 == n ? Integer.MAX_VALUE : nums2[partition2];

            if(nums1Left <= nums2Right && nums2Left <= nums1Right){
                if((m + n) % 2 == 0){
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                }
                return Math.max(nums1Left, nums2Left);
            }
            if(nums1Left > nums2Right){
                r = partition1 - 1;
            }else{
                l = partition1 + 1;
            }
        }
        return 0.0;
    }
}
