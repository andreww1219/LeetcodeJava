package Classic150.BinTree;

// 二叉搜索树中第K小的元素
public class Solution230 {
    int cnt;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        dfs(root, k);
        return result;
    }
    private void dfs(TreeNode node, int k) {
        if (node == null) return;
        dfs(node.left, k);
        cnt++;
        if (cnt == k) {
            result = node.val;
            return;
        }
        dfs(node.right, k);
    }
}
