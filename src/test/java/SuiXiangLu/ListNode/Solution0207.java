package SuiXiangLu.ListNode;

// 链表相交
public class Solution0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        int lenA=  0, lenB = 0;
        while (tempA != null){
            tempA = tempA.next;
            lenA++;
        }
        while (tempB != null){
            tempB = tempB.next;
            lenB++;
        }
        // 保证 A 是长的链表
        int diffLen;
        if (lenA < lenB){
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            diffLen = lenB - lenA;
        }else{
            diffLen = lenA - lenB;
        }

        tempA = headA;
        tempB = headB;
        for (int i = 0; i < diffLen; ++i)
            tempA = tempA.next;
        while (tempA != null){
            if (tempA == tempB)
                return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}
