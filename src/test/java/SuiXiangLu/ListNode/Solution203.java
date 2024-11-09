package SuiXiangLu.ListNode;

// 移除链表元素
/**
 * Definition for singly-linked list.
 * public class SuiXiangLu.ListNode {
 *     int val;
 *     SuiXiangLu.ListNode next;
 *     SuiXiangLu.ListNode() {}
 *     SuiXiangLu.ListNode(int val) { this.val = val; }
 *     SuiXiangLu.ListNode(int val, SuiXiangLu.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution203 {
    // 初见
    public ListNode removeElements1(ListNode head, int val) {
        ListNode newHead = head;
        while (newHead != null && newHead.val == val)
            newHead = newHead.next;
        ListNode p = newHead;
        while (p != null && p.next != null) {
            if (p.next.val == val){
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return newHead;
    }

    // 参考题解
    public ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == val){
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
