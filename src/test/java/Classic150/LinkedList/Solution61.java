package Classic150.LinkedList;


// 旋转链表
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        int len = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            len++;
        }
        iter.next = head;   // 接上头节点
        /// 找到断开处
        int offset = len - (k % len);
        // 找到新的头节点
        ListNode pre = new ListNode(0, head);
        for (int i = 0; i < offset; ++i)
            pre = pre.next;
        ListNode newHead = pre.next;
        // 断开
        pre.next = null;
        return newHead;
    }
}
