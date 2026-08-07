class WordDictionary {

    Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node current = root;
        if(word == null){
            return;
        }
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new Node();
            }
            if(i == word.length() - 1){
                current.children[index].eow = true;
            }
            current = current.children[index];
        }

    }
    
    public boolean search(String word) {
        return searchTheWord(word, 0, root);
    }

    public boolean searchTheWord(String word, int j, Node root) {
        Node current = root;
        for(int i = j; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(var child : current.children){
                    if(child != null && searchTheWord(word, i + 1, child)){
                        return true;
                    }
                }
                return false;
            }else{
                int index = word.charAt(i) - 'a';
                if(current.children[index] == null){
                    return false;
                }
                if(i == word.length() - 1 && !current.children[index].eow){
                    return false;
                }
                current = current.children[index];
            }
        }
        return current.eow;
    }
}

class Node{
    Node[] children;
    boolean eow;

    public Node(){
        this.children = new Node[26];
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
        this.eow = false;
    }
}
