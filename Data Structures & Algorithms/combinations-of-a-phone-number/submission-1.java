class Solution {

    public String[] digitsArray = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();

        combinations(digits, res, "", 0);
        return res;
        
    }

    public void combinations(String digits, List<String> res, String letterTemp, int i){
        if(i == digits.length()){
            res.add(letterTemp);
            return;
        }
        String strAtIndex = digitsArray[digits.charAt(i) - '0'];
        for(char c : strAtIndex.toCharArray()){
            combinations(digits, res, letterTemp + c, i + 1);
        }
    }
}
