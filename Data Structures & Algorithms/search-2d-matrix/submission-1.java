class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null){
            return true;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            int midRow = mid / n;
            int midCol = mid % n;

            if(matrix[midRow][midCol] == target){
                return true;
            }else if(matrix[midRow][midCol] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }
}
