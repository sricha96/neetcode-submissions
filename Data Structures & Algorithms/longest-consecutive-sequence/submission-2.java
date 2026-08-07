class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int longestLength = 0;
        for(Integer i : nums){
            map.put(i, Boolean.FALSE);
        }
        for(Integer i : nums){
            int currentLength = 1;
            int nextNum = i+1;
            int prevNum = i-1;
            while(map.containsKey(nextNum) && !map.get(nextNum)){
                currentLength ++;
                map.put(nextNum, Boolean.TRUE);
                nextNum ++;
            }
            while(map.containsKey(prevNum) && !map.get(prevNum)){
                currentLength ++;
                map.put(prevNum, Boolean.TRUE);
                prevNum --;
            }
            longestLength = Math.max(longestLength, currentLength);
        }
        return longestLength;
    }
}
