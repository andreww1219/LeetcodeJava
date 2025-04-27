package Classic150.BinTree;


// 验证二叉搜索树
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, Long.MIN_VALUE, (long)root.val - 1)
                && isValidBST(root.right, (long)root.val + 1, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node, long l, long r) {
        if (node == null) return true;
        if (!(node.val >= l && node.val <= r)) return false;
        return isValidBST(node.left, l, (long)node.val - 1)
                && isValidBST(node.right, (long)node.val + 1, r);
    }
}
