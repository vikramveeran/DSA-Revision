package LL;
import java.util.*;
import java.util.HashMap;

public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key,int value){
             this.key = key;
             this.value = value;
        }

    }
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;
    private final int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy sentinel nodes to avoid null checks at boundaries
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Unlink an existing node from the doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // Insert a node right before `tail` (most recently used position)
    private void insert(Node node){
         Node prev = tail.prev;
         prev.next = node;
         node.prev  = prev;
        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);

        if (map.size() > capacity) {
            // `head.next` is always the least recently used node
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1; key 2 becomes LRU

        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)

        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}

// PATTERN : HashMap + Doubly Linked List

/*Two main data structures:
1. HashMap – Find nodes in O(1).
2. Doubly Linked List – Move nodes and remove them in O(1). */


/*I implement LRU Cache using a HashMap and a Doubly Linked List.

The HashMap stores the key and its corresponding node, allowing O(1) average lookup.

The Doubly Linked List maintains the usage order. The head represents the least recently used side, and the tail represents the most recently used side.

Whenever get() or put() accesses an existing key, I move that node to the most recently used position.

When the capacity is exceeded, I remove the node next to head and delete its key from the HashMap.

Both get() and put() take O(1) average time. */

