class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int index = 0;
        int[] res = new int[k];
        for(int i = bucket.length - 1; i >= 0 && index < k; i--){
            if(bucket[i] != null){
                for(int j : bucket[i]){
                    res[index++] = j;
                }
            }
        }
        return res;
    }
}
