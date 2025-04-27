package Classic150.BinTree;


// 路径总和
public class Solution112 {

    private boolean backtrace(TreeNode node, int curSum, int targetSum) {
        if (node == null) return false;
        int sum = curSum + node.val;
        if (sum == targetSum && node.left == null && node.right == null) return true;
        if (backtrace(node.left, sum, targetSum))
            return true;
        if (backtrace(node.right, sum, targetSum))
            return true;
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return backtrace(root, 0, targetSum);
    }
}
