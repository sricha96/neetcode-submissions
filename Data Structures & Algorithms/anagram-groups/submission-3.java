class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null){
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String sortedStr = new String(s);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        res.addAll(map.values());
        return res;
    }
}
