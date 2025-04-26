package Classic150.LinkedList;


// K个一组反转链表
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        // 计算反转的次数
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // 按组反转
        ListNode lastTail = dummy;
        int times = len / k;
        for (int i = 0; i < times; ++i) {
            ListNode pre = lastTail, front = pre.next, tail = pre.next;
            for (int j = 0; j < k; ++j) {
                ListNode next = tail.next;
                tail.next = pre;
                pre = tail;
                tail = next;
            }
            lastTail.next = pre;
            front.next = tail;
            lastTail = front;
        }
        return dummy.next;
    }
}
