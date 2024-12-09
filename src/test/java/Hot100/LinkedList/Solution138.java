package Hot100.LinkedList;


import java.util.*;

// 随机链表的复制
public class Solution138 {
    // 初见 O(N^2)
    public Node copyRandomList1(Node head) {
        List<Node> ori = new ArrayList<>();
        List<Node> res = new ArrayList<>();
        while (head != null) {
            ori.add(head);
            res.add(new Node(head.val));
            head = head.next;
        }
        int len = ori.size();
        if (len == 0) return null;
        for (int i = 0; i < len; ++i) {
            Node oriNode = ori.get(i), resNode = res.get(i);
            if (oriNode.random != null) resNode.random = res.get(ori.indexOf(oriNode.random));
            if (i < len - 1) resNode.next = res.get(i + 1);
        }
        return res.get(0);
    }
    // 标准题解 回溯+哈希表 O(N)
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.next = copyRandomList2(head.next);
        newHead.random = copyRandomList2(head.random);
        return newHead;
    }
    // 题解 哈希表
    public Node copyRandomList3(Node head) {
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
