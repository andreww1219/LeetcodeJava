package Classic150.DivideAndConquer;


// 排序链表
public class Solution148 {
    class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    private ListNode sortList(ListNode head, ListNode tail) {
        // 将[head, tail)区间的链表节点排序
        if (head == null) return null;
        if (head.next == tail) {
            head.next = null;   // 为了合并时判断末尾
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail)
                fast = fast.next;
        }
        // 找到前后两个链表的第一个节点
        ListNode mid = slow;
        ListNode formerHead = sortList(head, mid);
        ListNode latterHead = sortList(mid, tail);
        return merge(formerHead, latterHead);
    }
    private ListNode merge(ListNode formerHead, ListNode latterHead) {
        ListNode dummy = new ListNode(), cur = dummy;
        ListNode cur1 = formerHead, cur2 = latterHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null)
            cur.next = cur1;
        if (cur2 != null)
            cur.next = cur2;
        return dummy.next;
    }
}
