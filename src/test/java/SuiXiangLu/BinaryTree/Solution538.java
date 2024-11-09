package SuiXiangLu.BinaryTree;

import java.util.Stack;

// 把二叉搜索树转换为累加树
public class Solution538 {
    // 迭代版
    public TreeNode convertBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        TreeNode pre = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.left != null) stack.push(node.left);
                stack.push(node);
                stack.push(null);
                if (node.right != null) stack.push(node.right);
            } else {
                node = stack.pop();
                if (pre != null) node.val += pre.val;
                pre = node;
            }
        }
        return root;
    }
    // 递归版
    TreeNode pre = null;
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return root;
        if (root.right != null) convertBST2(root.right);
        if (pre != null) root.val += pre.val;
        pre = root;
        if (root.left != null) convertBST2(root.left);
        return root;
    }
}
