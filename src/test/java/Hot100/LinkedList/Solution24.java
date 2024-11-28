package Hot100.LinkedList;

// 两两交换链表中的节点
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next, node2 = cur.next.next, node3 = cur.next.next.next;
            cur.next = node2;
            cur.next.next = node1;
            cur.next.next.next = node3;
            cur = node1;
        }
        return dummy.next;
    }
}
