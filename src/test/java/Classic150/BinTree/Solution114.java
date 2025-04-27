package Classic150.BinTree;


// 二叉树展开为链表
public class Solution114 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                // 将右节点接到前驱节点
                TreeNode right = cur.right;
                TreeNode iter = cur.left;
                while (iter.right != null) iter = iter.right;
                iter.right = right;
                // 将左节点放到右边
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
