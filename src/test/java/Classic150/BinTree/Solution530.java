package Classic150.BinTree;

// 二叉搜索树的最小绝对差
public class Solution530 {
    private int ans;
    private int pre;
    private final int IMPOSSIBLE = -1;
    public int getMinimumDifference(TreeNode root) {
        pre = IMPOSSIBLE;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (pre != IMPOSSIBLE)
            ans = Math.min(ans, node.val - pre);
        pre = node.val;
        dfs(node.right);
    }
}
