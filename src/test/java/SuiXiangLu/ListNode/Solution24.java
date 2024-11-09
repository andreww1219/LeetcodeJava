package SuiXiangLu.ListNode;

// 两两交换链表中的节点
public class Solution24 {


    // 递归（初见）
    public ListNode swapPairs1(ListNode cur) {
        if (cur != null && cur.next != null){
            ListNode next = cur.next;
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            cur.next = swapPairs1(temp);
            return next;
        }
        return cur;
    }

    // 递归（参考答案）
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 迭代（参考答案）
    public ListNode swapPairs3(ListNode head) {
        ListNode dumpNode = new ListNode();
        dumpNode.next = head;
        ListNode cur = dumpNode;
        while (cur.next != null && cur.next.next != null){
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = node1;
        }
        return dumpNode.next;
    }
}
