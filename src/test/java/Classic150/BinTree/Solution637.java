package Classic150.BinTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树的层平均值
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.add(root);
        List<Double> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            int size = que.size();
            double sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = que.poll();
                sum += node.val;
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
            ans.add(sum / size);
        }
        return ans;
    }
}
