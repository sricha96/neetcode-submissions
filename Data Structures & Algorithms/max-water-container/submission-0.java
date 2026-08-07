class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int i = 0;
        int j = heights.length - 1;
        while(i<j){
            int area = (j-i) * Math.min(heights[i], heights[j]);
            res = Math.max(res, area);
            if(heights[i] > heights[j]){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }
}
