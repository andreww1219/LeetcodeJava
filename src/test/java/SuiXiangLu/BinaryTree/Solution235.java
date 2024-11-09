package SuiXiangLu.BinaryTree;

// 二叉搜索树的最近公共祖先
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val)
            return lowestCommonAncestor(root, q, p);
        if (root.left != null && root.val < p.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.right != null && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
