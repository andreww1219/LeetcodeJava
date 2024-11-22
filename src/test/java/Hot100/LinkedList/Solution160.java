package Hot100.LinkedList;

// 相交链表
public class Solution160 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) { curA = curA.next; lenA++;}
        while (curB!= null) { curB = curB.next; lenB++;}
        // 保证A比B长
        if (lenA < lenB) {
            int tempLen = lenA; lenA = lenB; lenB = tempLen;
            ListNode tempNode = headA; headA = headB; headB = tempNode;
        }
        for (int i = 0; i < lenA - lenB; ++i) headA = headA.next;
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    // 极简标准题解
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        // 相交: lenA = a + c, lenB = b + c
        //  不等长: A 走一遍 a + c + b, B 走一遍 b + c + a 到一块
        //  等长: 同上
        // 不相交
        //  不等长: A 走一遍 a + c + b, B 走一遍 b + c + a 同时为 null
        //  等长: 同上
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
