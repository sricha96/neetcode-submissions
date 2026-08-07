class Solution {
    public int maxArea(int[] heights) {
        int area = 1;
        int res = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r){
            area = (r - l) * Math.min(heights[l], heights[r]);
            res = Math.max(area, res);
            if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
            }
        }
        return res;
    }
}
