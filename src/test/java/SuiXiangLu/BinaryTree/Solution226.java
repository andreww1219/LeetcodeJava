package SuiXiangLu.BinaryTree;

// 翻转二叉树
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tempLeft = root.left;
        root.left = root.right;
        root.right = tempLeft;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
