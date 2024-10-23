package Greedy;


// 监控二叉树
public class Solution968 {
    // 初见通过 140/171 无法判断头节点是否被覆盖
    public int minCameraCover1(TreeNode root) {
        // val = 0/1/2 分别代表 无覆盖/有覆盖/有摄像头
        if (root == null)
            return 0;
        int cur = minCameraCover1(root.left) + minCameraCover1(root.right);

        int left = root.left != null? root.left.val: -1;
        int right = root.right != null? root.right.val: -1;
        if (left == 0 || right == 0) {
            // 需要在当前节点放灯
            cur++;
            root.val = 2;
        } else if (left == 2 || right == 2) {
            root.val = 1;
        }
        return cur;
    }
    // 标准题解
    int result = 0;
    private int traverse(TreeNode node) {
        if (node == null) return 1;             // 空节点已被覆盖
        int left = traverse(node.left);
        int right = traverse(node.right);
        if (left == 0 || right == 0) {result++; return 2;} // 需要放灯
        if (left == 2 || right == 2) return 1;  // 当前节点被覆盖
        return 0;
    }
    public int minCameraCover2(TreeNode root) {
        if (traverse(root) == 0)
            result++;
        return result;
    }
}
