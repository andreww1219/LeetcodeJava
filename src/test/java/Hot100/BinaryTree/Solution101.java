package Hot100.BinaryTree;


// 对称二叉树
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode left = root.left, right = root.right;
        return isSymmetric(left, right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
