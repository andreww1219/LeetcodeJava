package Classic150.BinTree;


// 求根节点到叶节点数字之和
public class Solution129 {
    private int sum = 0;
    private void backtrace(TreeNode node, int curSum) {
        if (node == null) return;
        curSum = curSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += curSum;
            return;
        }
        backtrace(node.left, curSum);
        backtrace(node.right, curSum);
    }
    public int sumNumbers(TreeNode root) {
        backtrace(root, 0);
        return sum;
    }
}
