package Hot100.BinaryTree;


import java.util.ArrayDeque;
import java.util.Deque;

// 二叉搜索树中的第K小的元素
public class Solution230 {
    int result;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        recursion(root, k);
        return result;
    }
    private void recursion(TreeNode root, int k) {
        if (root == null) return;
        recursion(root.left, k);
        cnt++;
        if (cnt == k) {
            result = root.val;
            return;
        }
        recursion(root.right, k);
    }
}
