class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    int capacity;
    HashMap<Integer, Node> map;

    Node left;   // Least Recently Used side
    Node right;  // Most Recently Used side

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    // Remove node from current position
    public void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node just before right
    // So it becomes Most Recently Used
    public void insert(Node node) {

        Node last = right.prev;

        last.next = node;
        node.prev = last;

        node.next = right;
        right.prev = node;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // This node is now recently used
        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {

        // If key already exists, remove old node
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        // Create new node
        Node node = new Node(key, value);

        // Add to map
        map.put(key, node);

        // New node is Most Recently Used
        insert(node);

        // Capacity exceeded
        if (map.size() > capacity) {

            // Left side = Least Recently Used
            Node lru = left.next;

            remove(lru);
            map.remove(lru.key);
        }
    }
}