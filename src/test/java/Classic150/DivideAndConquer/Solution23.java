package Classic150.DivideAndConquer;


import org.junit.Test;

// 合并K个升序链表
public class Solution23 {
    @Test
    public void test() {
        ListNode[] lists = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        mergeKLists(lists);
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        for (int seg = 1; seg < len; seg += seg) {
            for (int start = 0; start < len && start + seg < len; start += 2 * seg) {
                ListNode dummy = new ListNode(), cur = dummy;
                ListNode cur1 = lists[start], cur2 = lists[start + seg];
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
                if (cur1 != null) cur.next = cur1;
                if (cur2 != null) cur.next = cur2;
                lists[start] = dummy.next;
            }
        }
        return lists[0];
    }
}
