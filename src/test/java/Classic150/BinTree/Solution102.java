package Classic150.BinTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树的层序遍历
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = que.poll();
                layer.add(node.val);
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
            ans.add(layer);
        }
        return ans;
    }
}
