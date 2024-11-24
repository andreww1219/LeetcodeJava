package Hot100.LinkedList;

import java.util.List;

// 回文链表
public class Solution234 {
    // 初见O(N) O(1)
    public boolean isPalindrome1(ListNode head) {
        // 求链表长度
        int len = 0;
        ListNode p = head;
        while (p != null) {p = p.next; len++;}
        // 反转一半链表
        ListNode pre = null, cur = head;
        for (int i = 0; i < len / 2; ++i) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 比较两边的链表
        if (len % 2 == 1) cur = cur.next;
        while (pre != null && cur != null) {
            if (pre.val != cur.val) return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }
    // 递归题解 O(N) O(N)
    ListNode curNode;
    private boolean recursion(ListNode node) {
        if (node != null) {
            if (!recursion(node.next)) return false;
            if (node.val != curNode.val) return false;
            curNode = curNode.next;
        }
        return true;
    }
    public boolean isPalindrome2(ListNode head) {
        curNode = head;
        return recursion(head);
    }
}
