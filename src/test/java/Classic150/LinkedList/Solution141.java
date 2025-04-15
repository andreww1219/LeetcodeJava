package Classic150.LinkedList;


// 环形链表
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (slow != null) slow = slow.next;
            if (fast != null) fast = fast.next;
            if (fast != null) fast = fast.next;
            if (fast != null && fast == slow) return true;
        }
        return false;
    }
}
