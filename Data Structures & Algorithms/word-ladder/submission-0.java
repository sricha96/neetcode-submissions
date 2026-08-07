class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String str : wordList){
            set.add(str);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            String word = curr.word;
            int seq = curr.seq;
            if(word.equals(endWord)){
                return seq;
            }
            for(int i = 0; i < word.length(); i++){
                for(char c = 'a' ; c <= 'z'; c++){
                    char[] replacedWord = word.toCharArray();
                    replacedWord[i] = c;
                    String newWord = new String(replacedWord);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        queue.add(new Pair(newWord, seq + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String word;
    int seq;

    public Pair(String word, int seq){
        this.word = word;
        this.seq = seq;
    }
}
