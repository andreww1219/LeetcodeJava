package ListNode;


// 环形链表
public class Solution142 {

    // 链表长 l    环长 s
    // 快指针移动 2n     慢指针移动 n
    // 那么有 2n - n = n = s

    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
