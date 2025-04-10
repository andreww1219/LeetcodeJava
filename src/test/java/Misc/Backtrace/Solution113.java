package Misc.Backtrace;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

// 路径总和II
public class Solution113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
        }
    }

    List<List<Integer>> ans = new ArrayList<>();

    private void backtrace(TreeNode node, List<Integer> path, int sum, int targetSum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && sum == targetSum) ans.add(new ArrayList<>(path));
        backtrace(node.left, path, sum, targetSum);     // 左节点
        backtrace(node.right, path, sum, targetSum);    // 右节点
        path.remove(path.size() - 1);
        sum -= node.val;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        backtrace(root, new ArrayList<>(), 0, targetSum);
        return ans;
    }
}
