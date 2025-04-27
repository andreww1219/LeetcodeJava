package Classic150.BinTree;


// 二叉树中的最大路径和
public class Solution124 {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return ans;
    }
    private int maxGain(TreeNode root) {
        // 从该节点往下的最大收获
        if (root == null) return 0;
        // 小于0不取
        int leftMaxGain = Math.max(maxGain(root.left), 0);
        int rightMaxGain = Math.max(maxGain(root.right), 0);
        ans = Math.max(ans, root.val + leftMaxGain + rightMaxGain);
        return root.val + Math.max(leftMaxGain, rightMaxGain);
    }
}
