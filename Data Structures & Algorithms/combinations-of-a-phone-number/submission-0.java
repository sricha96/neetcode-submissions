class Solution {

    private String[] digitsArray = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        solve(res, digits, "", 0);
        return res;
    }

    public void solve(List<String> res, String digits, String temp, int idx){
        if(idx == digits.length()){
            res.add(temp);
            return;
        }
        String str = digitsArray[digits.charAt(idx) - '0'];
        for(char c : str.toCharArray()){
            solve(res, digits, temp + c, idx + 1);
        }
    }
}
