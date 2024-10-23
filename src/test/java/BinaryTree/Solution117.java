package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// 填充每个节点的下一个右侧结点指针 II
public class Solution117 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node cur = queue.poll();
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            for (int i = 1; i < size; ++i) {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                cur.next = node;
                cur = node;
            }
        }
        return root;
    }
}
