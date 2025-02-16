package Hot100.BinaryTree;


// 二叉树的最近公共祖先
public class Solution236 {
    TreeNode result;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 返回值表示root包含p或者q
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right)))
            result = root;
        return left || right || (root.val == p.val || root.val == q.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }
}
