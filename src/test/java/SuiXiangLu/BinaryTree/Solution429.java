package SuiXiangLu.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


// N叉树的层序遍历

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
public class Solution429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        if (root != null)queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; ++i){
                Node front = queue.pollFirst();
                res.add(front.val);
                for (Node child: front.children)
                    queue.addLast(child);
            }
            result.add(res);
        }
        return result;
    }
}
