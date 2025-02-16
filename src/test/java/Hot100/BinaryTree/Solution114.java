package Hot100.BinaryTree;


// 二叉树展开为链表
public class Solution114 {
    public void flatten(TreeNode root) {
        // 寻找右节点的前驱
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;  // 将右节点移动到前驱之后
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
