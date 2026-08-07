class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordset = new HashSet<>(wordDict);
        return dfs(s, wordset, 0, new Boolean[s.length()]); 
    }

    public boolean dfs(String s, HashSet<String> wordset, int i, Boolean[] memo){
        if(i == s.length()){
            return true;
        }
        if(memo[i] != null) return memo[i];
        for(int j = i; j < s.length(); j++){
            if(wordset.contains(s.substring(i, j + 1))){
                if(dfs(s, wordset, j + 1, memo)){
                    return memo[i] = true;
                }
            }
        }
        return memo[i] = false;
    }
}
