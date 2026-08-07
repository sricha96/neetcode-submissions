class Solution {

    public String encode(List<String> strs) {
    	StringBuilder s = new StringBuilder();
    	for(String str : strs) {
    		int len = str.length();
    		s.append(len);
    		s.append("#");
    		s.append(str);
    	}

    	return s.toString();
    }

    public List<String> decode(String str) {
    	if(str == null) {
    		return null;
    	}
    	List<String> strs = new ArrayList<>();
    	int i = 0;
    	while(i < str.length()) {
    		int j = i;
    		while(str.charAt(j) != '#') {
    			j++;
    		}
    		int len = Integer.valueOf(str.substring(i, j));
    		i = j + 1 + len;
    		strs.add(str.substring(j + 1, i));
    	}
    	return strs;
    }
}
