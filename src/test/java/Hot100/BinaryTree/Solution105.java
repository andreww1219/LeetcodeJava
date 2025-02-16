package Hot100.BinaryTree;

import java.util.HashMap;

// 从前序与中序遍历序列构造二叉树
public class Solution105 {
    private HashMap<Integer, Integer> indexes = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 使用哈希表加速查找inorder
        for (int i = 0; i < inorder.length; ++i)
            indexes.put(inorder[i], i);
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int s1, int e1,
                               int[] inorder, int s2, int e2) {
        if (s1 > e1) return null;
        int rootVal = preorder[s1];
        TreeNode root = new TreeNode(rootVal);
        int splitPoint = indexes.get(rootVal);
        root.left = buildTree(preorder, s1 + 1, s1 + splitPoint - s2,
                inorder, s2, splitPoint - 1);
        root.right = buildTree(preorder, s1 + splitPoint - s2 + 1, e1,
                inorder, splitPoint + 1, e2);
        return root;
    }
}
