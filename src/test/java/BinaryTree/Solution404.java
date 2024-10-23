package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// 左叶子之和
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null)
                        sum += node.left.val;
                    else
                        queue.add(node.left);
                }
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return sum;
    }
}
