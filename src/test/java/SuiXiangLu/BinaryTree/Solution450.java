package SuiXiangLu.BinaryTree;

// 删除二叉搜索树中的节点
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (root.right == null)
            return root.left;
        else if (root.left == null)
            return root.right;
        else {
            TreeNode iter = root.left;
            while (iter.right != null)
                iter = iter.right;
            iter.right = root.right.left;
            root.right.left = root.left;
            return root.right;
        }
        return root;
    }
}
