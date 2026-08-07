class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
    	int longestLength = 0;
    	for(int num : nums) {
    		map.put(num, Boolean.FALSE);
    	}
    	for(int num : nums) {
    		int currLength = 1;
    		int nextNum = num + 1;
    		int prevNum = num - 1;
    		while(map.containsKey(nextNum) && !map.get(nextNum)) {
    			currLength++;
    			map.put(nextNum, Boolean.TRUE);
    			nextNum++;
    		}
    		while(map.containsKey(prevNum) && !map.get(prevNum)) {
    			currLength++;
    			map.put(prevNum, Boolean.TRUE);
    			prevNum--;
    		}
    		longestLength = Math.max(longestLength, currLength);
    	}
        return longestLength;
    }
}
