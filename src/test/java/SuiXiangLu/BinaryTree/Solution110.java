package SuiXiangLu.BinaryTree;

// 平衡二叉树
public class Solution110 {
    private int getHeight(TreeNode cur) {
        if (cur == null) return 0;
        int leftHeight = getHeight(cur.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(cur.right);
        if (rightHeight == -1) return -1;
        return Math.abs(leftHeight - rightHeight) > 1? -1: Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
}
