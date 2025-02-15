package Hot100.BinaryTree;

// 翻转二叉树
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left, right = root.right;
        root.left = right;
        root.right = left;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
