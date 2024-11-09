package SuiXiangLu.ListNode;

public class Solution707 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    ListNode head;
    int size;
    class MyLinkedList {

        public MyLinkedList() {
            size = 0;
            head = new ListNode();
        }
        public int get(int index) {
            if (index >= size || index < 0)
                return -1;
            ListNode cur = head;
            for (int i = 0; i <= index; ++i)
                cur = cur.next;
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }
        public void addAtIndex(int index, int val) {
            if (index > size || index < 0)
                return;
            ListNode cur = head;
            for (int i = 0; i < index; ++i){
                cur = cur.next;
            }
            cur.next = new ListNode(val, cur.next);
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0)
                return;
            ListNode cur = head;
            for (int i = 0; i < index; ++i){
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }
}
