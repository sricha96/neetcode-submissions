class Solution {
    public String foreignDictionary(String[] words) {

        int n = words.length;
		Map<Character, Set<Character>> adj = new HashMap();
		Map<Character, Integer> indegree = new HashMap();
		for (String str : words) {
			for (char c : str.toCharArray()) {
				adj.putIfAbsent(c, new HashSet<>());
				indegree.putIfAbsent(c, 0);
			}
		}
		for(int i = 0; i < n-1; i++) {
			String w1 = words[i];
			String w2 = words[i + 1];
			int minLen = Math.min(w1.length(), w2.length());
			if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
				return "";
			}
			for(int j = 0; j < minLen; j++) {
				if(w1.charAt(j) != w2.charAt(j)) {
					if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
						adj.get(w1.charAt(j)).add(w2.charAt(j));
						indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
					}
					break;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		Queue<Character> queue = new LinkedList<>();
		for(char c : indegree.keySet()) {
			if(indegree.get(c) == 0) {
				queue.add(c);
			}
		}
		
		while(!queue.isEmpty()) {
			char c = queue.poll();
			res.append(c);
			for(char nei : adj.get(c)) {
				indegree.put(nei, indegree.get(nei) - 1);
				if(indegree.get(nei) == 0) {
					queue.add(nei);
				}
			}
		}
		if (res.length() != indegree.size()) {
            return "";
        }
		return res.toString();
	}

}
