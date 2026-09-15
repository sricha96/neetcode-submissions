class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
		if(nums == null){
			return -1;
		}

		for(int num : nums){
			map.put(num, Boolean.FALSE);
		}

		int maxLength = 0;
		for(int i = 0; i < nums.length; i++){
			int currentLength = 1;
			int prevNum = nums[i] - 1;
			int nextNum = nums[i] + 1;

			while(map.containsKey(prevNum) && !map.get(prevNum)){
				currentLength++;
				map.put(prevNum, Boolean.TRUE);
				prevNum--;
			}
			while(map.containsKey(nextNum) && !map.get(nextNum)){
				currentLength++;
				map.put(nextNum, Boolean.TRUE);
				nextNum++;
			}
			maxLength = Math.max(maxLength, currentLength);
		}
		return maxLength;
    }
}
