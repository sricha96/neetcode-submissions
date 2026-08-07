class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> [] bucket = new List[nums.length+1];
        int count = 0;
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int [] res = new int[k];
        for(int j = bucket.length-1; j>=0 && count < k ;j--){
            if(bucket[j] != null){
                for(Integer i : bucket[j]){
                    res[count++] = i;
                }
            }
        } 
        return res;
    }
}
