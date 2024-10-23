package BinaryTree;

// 二叉搜索树中的搜索
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        if (root.val < val)
            return searchBST(root.right, val);
        return searchBST(root.left, val);
    }
}
