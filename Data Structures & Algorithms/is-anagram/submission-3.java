class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
            return true;
        }
        if(s.length() != t.length()){
            return false;
        }
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] t2 = t.toCharArray();
        Arrays.sort(t2);
        for(int i = 0; i < s1.length; i++){
            if(s1[i] != t2[i]){
                return false;
            }
        }
        return true;
    }
}
