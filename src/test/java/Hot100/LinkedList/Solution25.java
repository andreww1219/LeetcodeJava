package Hot100.LinkedList;


import org.junit.Test;

// K个一组翻转链表
public class Solution25 {
    @Test
    public void test() {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        System.out.println(reverseKGroup(list, 3));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // 计算长度
        int len = 0;
        ListNode iter = head;
        while (iter != null) {iter = iter.next; ++len;}
        // 进行反转
        ListNode dummy = new ListNode(0, head);
        ListNode lastTail = dummy;
        ListNode pre = null, cur = head;
        for (int i = 0; i < len / k; ++i) {
            ListNode tail = cur;
            for (int j = 0; j < k; ++j) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            lastTail.next = pre;
            tail.next = cur;
            lastTail = tail;
        }
        return dummy.next;
    }
}
