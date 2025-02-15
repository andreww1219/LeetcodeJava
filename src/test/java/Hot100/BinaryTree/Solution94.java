package Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

// 二叉树的中序遍历
public class Solution94 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        recursion(root);
        return result;
    }
    private void recursion(TreeNode root) {
        if (root == null)
            return ;
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
    }
}
