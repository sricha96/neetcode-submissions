class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        solve(s, res, part, 0);
        return res;
    }

    public void solve(String s, List<List<String>> res, List<String> part, int i){
        if(i == s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                part.add(s.substring(i, j + 1));
                solve(s, res, part, j + 1);
                part.remove(part.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s. charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
