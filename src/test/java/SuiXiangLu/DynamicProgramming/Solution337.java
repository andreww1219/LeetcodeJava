package SuiXiangLu.DynamicProgramming;


import java.util.HashMap;

// 打家劫舍III
public class Solution337 {
    // 题解一 使用哈希表
    HashMap<TreeNode, Integer> f = new HashMap<>();   // 该节点被选中的最大权值
    HashMap<TreeNode, Integer> g = new HashMap<>();   // 该节点不被选中的最大权值
    public int rob1(TreeNode root) {
        dfs(root);
        return Math.max(f.get(root), g.get(root));
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
                    + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }
    // 题解二 使用长度为2的数组
    public int rob2(TreeNode root) {
        int[] res = dp(root);
        // 0 表示不偷，1表示偷
        return Math.max(res[0], res[1]);
    }
    int[] dp(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] val1 = dp(root.left);
        int[] val2 = dp(root.right);
        res[0] = Math.max(val1[0], val1[1]) + Math.max(val2[0], val2[1]);
        res[1] = root.val + val1[0] + val2[0];
        return res;
    }
}
