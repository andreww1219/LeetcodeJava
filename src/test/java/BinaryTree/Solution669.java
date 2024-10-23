package BinaryTree;

// 修建二叉搜索树
public class Solution669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val < low)
            return trimBST(root.right, low, high);
        else if (root.val > high)
            return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    // 初见写了个保留 (-inf, low), (high, +inf) 的
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val < low)
            root.right = trimBST2(root.right, low, high);
        else if (root.val > high)
            root.left = trimBST2(root.left, low, high);
        else if (root.left == null)
            root = trimBST2(root.right, low, high);
        else if (root.right == null)
            root = trimBST2(root.left, low, high);
        else {
            TreeNode iter = root.left;
            while (iter.right != null)
                iter = iter.right;
            iter.right = root.right.left;
            root.right.left = root.left;
            root = trimBST2(root.right, low, high);
        }
        return root;
    }
}
