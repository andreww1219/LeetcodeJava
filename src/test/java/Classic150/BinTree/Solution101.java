package Classic150.BinTree;


// 对称二叉树
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null)
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        return left == null && right == null;
    }
}
