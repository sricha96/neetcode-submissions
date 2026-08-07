class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if((hand.length % groupSize) != 0){
            return false;
        }
        Map<Integer, Integer> handCount = new HashMap<>();
        for(int h : hand){
            handCount.put(h, handCount.getOrDefault(h, 0) + 1);
        }

        Arrays.sort(hand);
        for(int num : hand){
            if(!handCount.containsKey(num)){
                return false;
            }
            if(handCount.get(num) > 0){
                for(int i = num; i < num + groupSize; i++){
                    if(handCount.getOrDefault(i,0) == 0){
                        return false;
                    }
                    handCount.put(i, handCount.get(i) - 1);
                }
            }
        }
        return true;
    }
}
