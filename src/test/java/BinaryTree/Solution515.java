package BinaryTree;

import java.util.*;

public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Integer maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                maxValue = Math.max(maxValue, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(maxValue);
        }
        return result;
    }
}
