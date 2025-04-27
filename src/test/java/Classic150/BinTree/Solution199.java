package Classic150.BinTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树的右视图
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.add(root);
        List<Integer> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = que.poll();
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
                if (i == size - 1) ans.add(node.val);
            }
        }
        return ans;
    }
}
