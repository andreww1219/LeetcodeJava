package Hot100.BinaryTree;

import java.util.Map;

// 二叉树中的最大路径和
public class Solution124 {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return result;
    }
    private int maxGain(TreeNode root) {
        if (root == null) return 0;
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int candidateResult = leftGain + rightGain + root.val;
        result = Math.max(result, candidateResult);
        return Math.max(leftGain, rightGain) + root.val;
    }
}
