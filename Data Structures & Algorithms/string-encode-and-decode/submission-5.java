class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == null){
            return null;
        }
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.valueOf(str.substring(i, j));
            i = len + j + 1;
            String s = str.substring(j + 1, i);
            res.add(s);
        }
        return res;
    }
}
