class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1_count = new int[26];
        int[] s2_count = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1_count[s1.charAt(i) - 'a']++;
            s2_count[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(s1_count[i] == s2_count[i]){
                matches++;
            }
        }

        for(int r = s1.length(); r < s2.length(); r++){
            if(matches == 26){
                return true;
            }

            int index = s2.charAt(r) - 'a';
            s2_count[index]++;
            if(s1_count[index] == s2_count[index]){
                matches++;
            }else if(s1_count[index] + 1 == s2_count[index]){
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2_count[index]--;
            if(s1_count[index] == s2_count[index]){
                matches++;
            }else if(s1_count[index] - 1 == s2_count[index]){
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
