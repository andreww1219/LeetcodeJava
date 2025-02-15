package Hot100.BinaryTree;


// 二叉树的直径
public class Solution543 {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int depthL = depth(root.left);
        int depthR = depth(root.right);
        result = Math.max(depthL + depthR, result);
        return 1 + Math.max(depthL, depthR);
    }
}
