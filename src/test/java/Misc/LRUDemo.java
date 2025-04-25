package Misc;

import java.util.HashMap;
import java.util.Map;

public class LRUDemo {

    class LRUCache {

        class DLinkedNode {
            int key;
            int val;
            DLinkedNode prev, next;
            DLinkedNode(){}
            DLinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
        int size;
        int capacity;

        DLinkedNode head, tail;
        Map<Integer, DLinkedNode> map;
        LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
        }
        int get(int key) {
            if (map.containsKey(key)) {
                DLinkedNode node = map.get(key);
                removeNode(node);
                addToHead(node);
                return node.val;
            }
            return -1;
        }
        void put(int key, int val) {
            if (map.containsKey(key)) {
                DLinkedNode node = map.get(key);
                removeNode(node);
            }
            DLinkedNode newNode = new DLinkedNode(key, val);
            addToHead(newNode);
            if (size > capacity)
                removeLast();
        }
        void removeNode(DLinkedNode node) {
            DLinkedNode prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            map.remove(node.key);
            size--;
        }
        void addToHead(DLinkedNode node) {
            DLinkedNode first = head.next;
            head.next = node;
            node.prev = head;
            node.next = first;
            first.prev = node;
            map.put(node.key, node);
            size++;
        }
        void removeLast() {
            DLinkedNode last = tail.prev;
            if (last == head) return;
            DLinkedNode preLast = last.prev;
            preLast.next = tail;
            tail.prev = preLast;
            map.remove(last.key);
            size--;
        }
    }
}
