class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        partitionString(res, part, 0, s);
        return res;
    }

    public void partitionString(List<List<String>> res, List<String> part, int i, String s){
        if(i == s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(palindrome(s, i, j)){
                part.add(s.substring(i, j + 1));
                partitionString(res, part, j + 1, s);
                part.remove(part.size() - 1);
            }
        }
    }

    public boolean palindrome(String s, int startIndex, int endIndex){
        while(startIndex <= endIndex){
            if(s.charAt(startIndex) != s.charAt(endIndex)){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
