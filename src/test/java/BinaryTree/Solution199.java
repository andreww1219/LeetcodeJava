package BinaryTree;

import java.util.*;

// 二叉树的右视图
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; ++i){
                TreeNode front = queue.poll();
                if (i == size - 1) result.add(front.val);
                if (front.left != null) queue.add(front.left);
                if (front.right != null) queue.add(front.right);
            }
        }
        return result;
    }
}
