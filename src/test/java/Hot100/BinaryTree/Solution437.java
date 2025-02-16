package Hot100.BinaryTree;

import java.util.HashMap;
import java.util.Map;

// 路径总和III
public class Solution437 {
    // 解法一：深搜遍历 O(N^2)
    public int pathSum1(TreeNode root, long targetSum) {
        if (root == null) return 0;
        int result = rootSum(root, targetSum);
        result += pathSum1(root.left, targetSum);
        result += pathSum1(root.right, targetSum);
        return result;
    }
    private int rootSum(TreeNode root, long targetSum) {
        // 以该节点为根，路径和为targetSum的路径数
        if (root == null) return 0;
        int result = 0;
        if (root.val == targetSum) result++;
        result += rootSum(root.left, targetSum - root.val);
        result += rootSum(root.right, targetSum - root.val);
        return result;
    }
    // 解法二：前缀和
    Map<Long, Integer> paths = new HashMap<>();
    public int pathSum2(TreeNode root, long targetSum) {
        // 保存 root 到当前节点出现的路径和的路径数
        paths.put(0L, 1);
        return dfs(root, 0, targetSum);
    }
    private int dfs(TreeNode root, long curSum, long targetSum) {
        if (root == null) return 0;
        int val = root.val;
        curSum += val;
        int result = paths.getOrDefault(curSum - targetSum, 0);
        paths.put(curSum, paths.getOrDefault(curSum, 0) + 1);
        result += dfs(root.left, curSum, targetSum);
        result += dfs(root.right, curSum, targetSum);
        paths.put(curSum, paths.getOrDefault(curSum, 0) - 1);
        return result;
    }
}
