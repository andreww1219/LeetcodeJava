package ListNode;


// 删除链表的倒数第N个节点
public class Solution19 {
    // 初见（无法通过 size == n ）的情况
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode slow = head, fast = head;
        // fast 提前走 n 步
        // when n == 2
        // o -> o -> o:slow -> o-> o  fast
        for (int i = 0; i <= n; ++i)
            fast = fast.next;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    // 标准题解（快慢指针+哑节点）
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dumpNode = new ListNode(0, head);
        ListNode slow = dumpNode, fast = dumpNode;
        for (int i = 0; i <= n; ++i)
            fast = fast.next;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dumpNode.next;
    }
}
