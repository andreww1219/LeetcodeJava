package SuiXiangLu.BinaryTree;

import java.util.*;

// 对称二叉树
public class Solution101 {
    // 迭代写法
    public boolean isSymmetric1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            deque.addFirst(left.right);
            deque.addFirst(left.left);
            deque.addLast(right.left);
            deque.addLast(right.right);
        }
        return true;
    }
    // 递归写法
    public boolean isSymmetric2(TreeNode root) {
        return compare(root.left, root.right);
    }
    private boolean compare(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        boolean compareResult1 = compare(left.left, right.right);
        boolean compareResult2 = compare(left.right, right.left);
        return compareResult1 && compareResult2;
    }
}
