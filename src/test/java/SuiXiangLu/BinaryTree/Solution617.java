package SuiXiangLu.BinaryTree;


// 合并二叉树
public class Solution617 {
    // 初见
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode res = null;
        if (root1 != null && root2 != null) {
            res = new TreeNode(root1.val + root2.val);
            res.left = mergeTrees(root1.left, root2.left);
            res.right = mergeTrees(root1.right, root2.right);
        } else if (root1 != null) {
            res = new TreeNode(root1.val);
            res.left = root1.left;
            res.right = root1.right;
        } else if (root2 != null){
            res = new TreeNode(root2.val);
            res.left = root2.left;
            res.right = root2.right;
        }
        return res;
    }

    // 简化版本 题解
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        root1.val += root2.val;
        root1.left = mergeTrees2(root1.left, root2.left);
        root1.right = mergeTrees2(root1.right, root2.right);
        return root1;
    }
}
