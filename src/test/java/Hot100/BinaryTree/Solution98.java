package Hot100.BinaryTree;


// 验证二叉搜索树
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val > min && root.val < max)
            return isValidBST(root.left, min, new Long(root.val))
                    && isValidBST(root.right, new Long(root.val), max);
        return false;
    }
}
