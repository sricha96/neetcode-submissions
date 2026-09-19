class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null){
            return 0;
        }
        int startSpeed = 1;
        int endSpeed = 0;
        for(int i = 0; i < piles.length; i++){
            endSpeed = Math.max(endSpeed, piles[i]);
        }
        int res = 0;
        while(startSpeed <= endSpeed){
            int mid = startSpeed + (endSpeed - startSpeed)/2;
            if(hoursSpent(piles, h, mid)){
                res = mid;
                endSpeed = mid - 1;
            }else{
                startSpeed = mid + 1;
            }
        }
        return res;
    }

    public boolean hoursSpent(int[] piles, int h, int mid){
        int hoursSpent = 0;
        for(int i = 0; i < piles.length; i++){
            hoursSpent = hoursSpent + (piles[i] / mid);

            if(piles[i] % mid > 0){
                hoursSpent++;
            }

            if(hoursSpent > h){
                return false;
            }
        }
        return true;
    }
}
