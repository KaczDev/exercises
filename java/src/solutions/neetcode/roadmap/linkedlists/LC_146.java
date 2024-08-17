package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
public class LC_146 implements Solution {
    @Override
    public void solve() {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class LRUCache {

        private Map<Integer, Node> cache; // Map Key to Nodes
        // left = LeastRecentlyUsed (lru)
        private Node left;
        // right = MostRecentlyUser (mru)
        private Node right;
        private int capacity;

        public LRUCache(int capacity) {
            this.cache = new HashMap<>(capacity + 1);
            this.capacity = capacity;
            this.left = new Node(0, 0);
            this.right = new Node(0, 0);
            this.left.next = this.right;
            this.right.prev = this.left;
        }

        // remove from the list
        private void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        // insert at right
        private void insert(Node node) {
            Node prev = this.right.prev;
            Node next = this.right;

            prev.next = node;
            next.prev = node;

            node.next = next;
            node.prev = prev;
        }

        public int get(int key) {
            if (this.cache.containsKey(key)) {
                Node node = this.cache.get(key);
                this.remove(node);
                this.insert(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (this.cache.containsKey(key)) {
                this.remove(this.cache.get(key));
            }
            Node node = new Node(key, value);
            this.cache.put(key, node);
            this.insert(node);

            if (this.cache.size() > this.capacity) {
                // remove from the list and delete the LRU from the map
                Node lru = this.left.next;
                this.remove(lru);
                this.cache.remove(lru.key);
            }
        }
    }
}
