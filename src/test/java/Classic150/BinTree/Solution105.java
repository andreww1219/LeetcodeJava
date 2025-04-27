package Classic150.BinTree;


import java.util.HashMap;
import java.util.Map;

// 从前序与中序遍历序列构造二叉树
public class Solution105 {
    private Map<Integer, Integer> indexesOfInorder = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for (int i = 0; i < len; ++i)
            indexesOfInorder.put(inorder[i], i);
        return buildTree(preorder, 0, len - 1,
                         inorder, 0, len - 1);
    }
    private TreeNode buildTree(int[] preorder, int l1, int r1,
                               int[] inorder, int l2, int r2) {
        if (l1 > r1) return null;
        int split = indexesOfInorder.get(preorder[l1]);
        int leftLen = split - l2;
        TreeNode root = new TreeNode(preorder[l1]);
        root.left = buildTree(preorder, l1 + 1, l1 + leftLen,
                                inorder, l2, split - 1);
        root.right = buildTree(preorder, l1 + leftLen + 1, r1,
                                inorder, split + 1, r2);
        return root;
    }
}
