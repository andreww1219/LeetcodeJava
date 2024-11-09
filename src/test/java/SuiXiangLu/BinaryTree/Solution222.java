package SuiXiangLu.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// 完全二叉树的节点个数
public class Solution222 {
    // 初见
    public int countNodes1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                ++cnt;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return cnt;
    }
    // 递归 求节点个数通解
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        int leftCount = countNodes2(root.left);
        int rightCount = countNodes2(root.right);
        return leftCount + rightCount + 1;
    }
}
