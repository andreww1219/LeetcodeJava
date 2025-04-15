package Classic150.LinkedList;


import java.util.HashMap;
import java.util.Map;

// 随机链表的复制
public class Solution138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node cur = dummy, ori = head;
        while (ori != null) {
            // 找到下一个节点
            Node next;
            if (map.containsKey(ori))
                next = map.get(ori);
            else
                next = new Node(ori.val);
            cur.next = next;
            map.put(ori, next);
            // 找到random节点
            if (ori.random != null) {
                Node random;
                if (map.containsKey(ori.random))
                    random = map.get(ori.random);
                else
                    random = new Node(ori.random.val);
                cur.next.random = random;
                map.put(ori.random, random);
            }
            // 迭代
            cur = cur.next;
            ori = ori.next;
        }
        return dummy.next;
    }
}
