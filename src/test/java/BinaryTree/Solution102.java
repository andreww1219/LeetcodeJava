package BinaryTree;

import java.util.*;

// 二叉树的层序遍历

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; ++i){
                TreeNode front = queue.pollFirst();
                res.add(front.val);
                if (front.left != null)queue.addLast(front.left);
                if (front.right != null)queue.addLast(front.right);
            }
            result.add(res);
        }
        return result;
    }
}
