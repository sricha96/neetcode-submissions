class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        int res = 0;

        for(int i = 0; i < piles.length; i++){
            end = Math.max(end, piles[i]);
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            if(isEatingSpeedValid(piles, mid, h)){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }

    public boolean isEatingSpeedValid(int[] piles, int mid, int h){
        int hoursSpent = 0;
        for(int i = 0; i < piles.length; i++){
            hoursSpent = hoursSpent + piles[i] / mid;
            if(piles[i] % mid != 0){
                hoursSpent++;
            }
            if(hoursSpent > h){
                return false;
            }
        }
        return true;
    }
}
