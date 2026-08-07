class Solution {
    public boolean isPalindrome(String s) {
        String lowerStr = s.toLowerCase();
        int i = 0;
        int j = lowerStr.length() - 1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(lowerStr.charAt(i))){
                i++;
            }while(i<j && !Character.isLetterOrDigit(lowerStr.charAt(j))){
                j--;
            }
            if(lowerStr.charAt(i) != lowerStr.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}
