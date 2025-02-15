package Hot100.LinkedList;


import java.util.*;

// LRU缓存
public class Solution146 {
    class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev, next;
            DLinkedNode() {}
            DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        HashMap<Integer, DLinkedNode> map = new HashMap<>();

        int capacity;
        int size;
        DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                DLinkedNode node = map.get(key);
                removeNode(node);
                addToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                DLinkedNode node = map.get(key);
                removeNode(node);
            }
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            map.put(key, newNode);
            if (size > capacity) {
                removeLast();
            }
        }
        void removeNode(DLinkedNode node) {
            DLinkedNode prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            map.remove(node.key);
            size--;
        }
        void addToHead(DLinkedNode node) {
            DLinkedNode next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            map.put(node.key, node);
            size++;
        }
        void removeLast() {
            DLinkedNode last = tail.prev;
            if (last.prev == head)
                return;
            DLinkedNode preOfLast = last.prev;
            preOfLast.next = tail;
            tail.prev = preOfLast;
            map.remove(last.key);
            size--;
        }
    }
}
