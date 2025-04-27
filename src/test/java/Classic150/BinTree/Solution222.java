package Classic150.BinTree;


import java.util.Deque;
import java.util.LinkedList;

// 完全二叉树的节点个数
public class Solution222 {
    // O(N)
    public int countNodes1(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        if (root != null) que.addFirst(root);
        int ans = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            ans += size;
            for (int i = 0; i < size; ++i) {
                TreeNode node = que.pollFirst();
                if (node.left != null) que.addFirst(node.left);
                if (node.right != null) que.addFirst(node.right);
            }
        }
        return ans;
    }
    // O(log^2 N)
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        // 计算层数
        int level = 0;
        TreeNode cur = root;
        while (cur != null) {
            cur = cur.left;
            level++;
        }
        // 二分查找节点存在情况
        int ans = -1;
        int l = 1 << (level - 1), r = (1 << level) - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (exist(root, mid, level)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    private boolean exist(TreeNode root, int code, int level) {
        int mask = 1 << (level - 2);
        TreeNode cur = root;
        while (mask > 0) {
            if ((code & mask) == 0) {
                if (cur.left == null) return false;
                cur = cur.left;
            } else {
                if (cur.right == null) return false;
                cur = cur.right;
            }
            mask >>= 1;
        }
        return true;
    }
}
