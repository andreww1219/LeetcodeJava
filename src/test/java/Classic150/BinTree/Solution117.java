package Classic150.BinTree;


import java.util.LinkedList;
import java.util.Queue;

// 填充每个节点的下一个右侧节点指针II
public class Solution117 {
    public Node connect(Node root) {
        Queue<Node> que = new LinkedList<>();
        if (root != null) que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            Node pre = que.poll();
            if (pre.left != null) que.add(pre.left);
            if (pre.right != null) que.add(pre.right);
            for (int i = 1; i < size; ++i) {
                Node node = que.poll();
                pre.next = node;
                pre = node;
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
        }
        return root;
    }
}
