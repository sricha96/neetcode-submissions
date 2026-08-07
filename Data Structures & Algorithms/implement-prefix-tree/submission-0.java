class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();
         
    }

    public void insert(String word) {
        Node current = root;
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
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            if(i == word.length() - 1 && current.children[index].eow == false){
                return false;
            }

            current = current.children[index];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return true;
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
