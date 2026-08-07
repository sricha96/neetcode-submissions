class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for(String str : strs){
            encode = encode.append(str.length()).append("#").append(str);
        }
        return encode.toString();

    }

    public List<String> decode(String str) {
        if(str == null){
            return null;
        }
        List<String> result = new ArrayList<>();
        int strLength = str.length();
        int i =0;
        while(i < strLength){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.valueOf(str.substring(i,j));
            i = j+1+length;
            result.add(str.substring(j+1,i));
        
        }
        return result;
    }
}
