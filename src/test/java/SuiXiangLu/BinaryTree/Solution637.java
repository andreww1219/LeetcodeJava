package SuiXiangLu.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树的层平均值
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Double sum = new Double(0.0);
            for (int i = 0; i < size; ++i){
                TreeNode front = queue.poll();
                sum += front.val;
                if (front.left != null) queue.add(front.left);
                if (front.right != null) queue.add(front.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
