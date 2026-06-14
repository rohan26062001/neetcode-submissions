class LRUCache {

    private final int capacity;
    private final Node head, tail;
    private final Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null)    return -1;
        remove(node);
        insertFront(head, node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.get(key) == null) {
            if(cache.size() == capacity) {
                int rm_key = tail.prev.key;
                remove(tail.prev);
                cache.remove(rm_key);
            }
            Node node = new Node(key, value);
            insertFront(head, node);
            cache.put(key, node);
        } else {
            Node node = cache.get(key);
            node.val = value;
            remove(node);
            insertFront(head, node);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertFront(Node head, Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}