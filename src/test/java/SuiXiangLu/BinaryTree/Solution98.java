package SuiXiangLu.BinaryTree;

// 验证二叉搜索树
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, Long lowerBound, Long upperBound){
        if (root == null)
            return true;
        if (root.val >= upperBound || root.val <= lowerBound)
            return false;
        return isValidBST(root.left, lowerBound, new Long(root.val))
                && isValidBST(root.right, new Long(root.val), upperBound);
    }
}
