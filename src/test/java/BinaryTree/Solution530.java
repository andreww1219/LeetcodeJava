package BinaryTree;

import java.util.*;

// 二叉搜索树的最小绝对差
public class Solution530 {
    // 中序遍历 迭代法
    public int getMinimumDifference1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int minValue = Integer.MAX_VALUE;
        if (root != null) stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                node = stack.pop();
                if (pre != null)
                    minValue = Math.min(node.val - pre.val, minValue);
                pre = node;
            }
        }
        return minValue;
    }

    // 递归
    private TreeNode pre;
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference2(TreeNode root) {
        traversal(root);
        return min;
    }
    private void traversal(TreeNode root) {
        if (root.left != null)
            traversal(root.left);
        if (pre != null)
            min = Math.min(min, root.val - pre.val);
        pre = root;
        if (root.right != null)
            traversal(root.right);
    }
}
