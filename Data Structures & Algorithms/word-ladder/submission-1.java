class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>();
        for(String word : wordList){
            if(!words.contains(word)){
                words.add(word);
            }
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String word = p.word;
            int seq = p.sequence;
            if(word.equals(endWord)){
                return seq;
            }
            for(int i = 0; i < word.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = c;
                    String newWord = new String(wordArray);
                    if(words.contains(newWord)){
                        words.remove(newWord);
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
    int sequence;

    Pair(String word, int sequence){
        this.word = word;
        this.sequence = sequence;
    }
}