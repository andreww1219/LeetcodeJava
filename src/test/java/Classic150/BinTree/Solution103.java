package Classic150.BinTree;


import java.util.*;

// 二叉树的锯齿形层序遍历
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.addLast(root);
        List<List<Integer>> ans = new ArrayList<>();
        boolean flag = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = flag ? deque.pollFirst() : deque.pollLast();
                layer.add(node.val);
                if (flag) {
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                } else {
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
            }
            ans.add(layer);
            flag = !flag;
        }
        return ans;
    }
}
