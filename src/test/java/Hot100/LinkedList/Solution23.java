package Hot100.LinkedList;

// 合并K个升序链表
public class Solution23 {
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0, null);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) cur.next = head1;
        if (head2 != null) cur.next = head2;
        return dummy.next;
    }
    // 初见 顺序合并 O(n k^2)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(0, lists[0]);
        for (int i = 1; i < lists.length; ++i)
            dummy.next = merge(dummy.next, lists[i]);
        return dummy.next;
    }
    // 标准题解 分治合并 O(n k logk)
    private ListNode mergerListsRecursive(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        return merge(mergerListsRecursive(lists, l, mid),
                mergerListsRecursive(lists, mid + 1, r));
    }
    public ListNode mergeKLists2(ListNode[] lists) {
        return mergerListsRecursive(lists, 0, lists.length - 1);
    }
}
