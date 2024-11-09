package SuiXiangLu.BinaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 从中序和后序遍历序列构造二叉树
public class Solution106 {
    // 递归 一个函数解决 version O(N^2)
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length <= 0)
            return null;
        int i = 0;
        while (inorder[i] != postorder[postorder.length - 1])
            i++;
        TreeNode mid = new TreeNode(inorder[i]);
        mid.left = buildTree1(Arrays.copyOfRange(inorder, 0, i),
                Arrays.copyOfRange(postorder, 0, i));
        mid.right = buildTree1(Arrays.copyOfRange(inorder, i + 1, inorder.length),
                Arrays.copyOfRange(postorder, i, postorder.length - 1));
        return mid;
    }
    // 递归 不使用复制数组 O(N)
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length <= 0)
            return null;
        return findNode(inorder, 0,
                postorder, 0, inorder.length);
    }

    private TreeNode findNode(int[] inorder, int inorderStartIndex,
                     int[] postorder, int postorderStartIndex, int arraySize) {
        if (arraySize == 0)
            return null;
        TreeNode mid = new TreeNode(postorder[postorderStartIndex + arraySize - 1]);
        int offset = 0;
        while (inorder[inorderStartIndex + offset] !=
                postorder[postorderStartIndex + arraySize - 1])
            offset++;
        mid.left = findNode(inorder, inorderStartIndex,
                postorder, postorderStartIndex, offset);
        mid.right = findNode(inorder, inorderStartIndex + offset + 1,
                postorder, postorderStartIndex + offset, arraySize - offset - 1);
        return mid;
    }
    // 使用 map 加速 offset 查询 O(N)

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        if (inorder.length <= 0)
            return null;
        for (int i = 0; i < inorder.length; ++i)
            map.put(inorder[i], i);
        return findNode2(inorder, 0,
                postorder, 0, inorder.length);
    }

    private TreeNode findNode2(int[] inorder, int inorderStartIndex,
                              int[] postorder, int postorderStartIndex, int arraySize) {
        if (arraySize == 0)
            return null;
        TreeNode mid = new TreeNode(postorder[postorderStartIndex + arraySize - 1]);
        int offset = map.get(postorder[postorderStartIndex + arraySize - 1]) - inorderStartIndex;
        mid.left = findNode2(inorder, inorderStartIndex,
                postorder, postorderStartIndex, offset);
        mid.right = findNode2(inorder, inorderStartIndex + offset + 1,
                postorder, postorderStartIndex + offset, arraySize - offset - 1);
        return mid;
    }
}
