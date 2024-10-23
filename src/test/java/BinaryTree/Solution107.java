package BinaryTree;

import java.util.*;

// 二叉树的层次遍历 II
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(result);
        return result;
    }
}
