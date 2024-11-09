package SuiXiangLu.BinaryTree;

// 二叉搜索树中的插入操作
public class Solution701 {
    // 初见
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val) {
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                insertIntoBST1(root.left, val);
        } else if (val > root.val) {
            if (root.right == null)
                root.right = new TreeNode(val);
            else
                insertIntoBST1(root.right, val);
        }
        return root;
    }

    // 精简版
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val)
                root.left = insertIntoBST2(root.left, val);
        else if (val > root.val)
                root.right = insertIntoBST2(root.right, val);
        return root;
    }

}
