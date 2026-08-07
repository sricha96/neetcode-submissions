class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1); 
        Arrays.sort(s2);
        if(s1 != null && s2 != null){
            for(int i = 0; i<= s1.length-1 ;i++){
                if(s1[i] != s2[i]){
                    return false;
                }
            }
        }
        return true;
    }
}
