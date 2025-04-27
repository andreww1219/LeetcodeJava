package Classic150.BinTree;


import java.util.HashMap;
import java.util.Map;

// 从中序与后序遍历序列构造二叉树
public class Solution106 {
    private Map<Integer, Integer> indexes = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        for (int i = 0; i < len; ++i)
            indexes.put(inorder[i], i);
        return buildTree(inorder, 0, len - 1,
                        postorder, 0, len - 1);
    }
    private TreeNode buildTree(int[] inorder, int l1, int r1,
                               int[] postorder, int l2, int r2) {
        if (l1 > r1) return null;
        TreeNode root = new TreeNode(postorder[r2]);
        int split = indexes.get(postorder[r2]);
        int leftLen = split - l1;
        root.left = buildTree(inorder, l1, split - 1,
                            postorder, l2, l2 + leftLen - 1);
        root.right = buildTree(inorder, split + 1, r1,
                            postorder, l2 + leftLen, r2 - 1);
        return root;
    }
}
