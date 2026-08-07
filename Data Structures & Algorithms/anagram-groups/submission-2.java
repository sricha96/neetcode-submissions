class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String sr = String.valueOf(s);
            if(!map.containsKey(sr)){
                map.put(sr, new ArrayList<>());
            }
            map.get(sr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
