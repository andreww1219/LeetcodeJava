package Classic150.LinkedList;


// 分隔链表
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0), greaterDummy = new ListNode(0);
        ListNode lessPre = lessDummy, greaterPre = greaterDummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                lessPre.next = cur;
                lessPre = lessPre.next;
            } else {
                greaterPre.next = cur;
                greaterPre = greaterPre.next;
            }
            cur = cur.next;
        }
        greaterPre.next = null;
        lessPre.next = greaterDummy.next;
        return lessDummy.next;
    }
}
