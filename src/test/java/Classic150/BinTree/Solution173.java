package Classic150.BinTree;


import java.util.*;

// 二叉搜索树迭代器
public class Solution173 {
    class BSTIterator1 {
        List<Integer> res;
        int offset;

        public BSTIterator1(TreeNode root) {
            res = new ArrayList<>();
            inorderTraverse(root);
            offset = 0;
        }
        private void inorderTraverse(TreeNode node) {
            if (node == null) return;
            inorderTraverse(node.left);
            res.add(node.val);
            inorderTraverse(node.right);
        }

        public int next() {
            return res.get(offset++);
        }

        public boolean hasNext() {
            return offset < res.size();
        }
    }
    class BSTIterator2 {
        TreeNode cur;
        Deque<TreeNode> stack;
        public BSTIterator2(TreeNode root) {
            stack = new LinkedList<>();
            cur = root;
        }
        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
