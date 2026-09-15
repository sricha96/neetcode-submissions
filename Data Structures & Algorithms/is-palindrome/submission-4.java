class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }
        String s1 = s.toLowerCase();
        int l = 0;
        int r = s1.length() - 1;
        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s1.charAt(l))){
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s1.charAt(r))){
                r--;
            }
            if(s1.charAt(l) != s1.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
