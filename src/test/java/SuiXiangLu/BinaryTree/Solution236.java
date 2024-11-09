package SuiXiangLu.BinaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 二叉树的最近公共祖先
public class Solution236 {
    // 初见
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        if (traverse(root, p, q)) res = root;
        if (root.left != null && traverse(root.left, p, q))
            res = lowestCommonAncestor1(root.left, p, q);
        else if (root.right != null && traverse(root.right, p, q))
            res = lowestCommonAncestor1(root.right, p, q);
        return res;
    }
    private boolean traverse(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        boolean hasP = false, hasQ = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if (node == p)
                    hasP = true;
                if (node == q)
                    hasQ = true;
                if (hasP && hasQ)
                    return true;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return false;
    }

    // 优化 后序遍历
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        boolean foundP = false, foundQ = false;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                TreeNode cur = stack.pop();
                if (cur == p)
                    foundP = true;
                if (cur == q)
                    foundQ = true;
                if (foundP && foundQ)
                    if (traverse(cur, p, q)) return cur;
            }
        }
        return null;
    }

    // 递归 标准题解
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null && right != null) return right;
        if (left != null && right == null) return left;
        return root;
    }
}
