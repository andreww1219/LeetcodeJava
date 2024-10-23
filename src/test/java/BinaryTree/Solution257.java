package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// 二叉树的所有路径
public class Solution257 {
    // 输入 cur 节点，以及到达 cur 节点的路径

    List<String> res = new ArrayList<>();
    private void getPath (TreeNode cur, String path) {
        if (cur == null) return ;
        if (cur.left == null && cur.right == null)
            res.add(new StringBuilder(path).append(cur.val).toString());
        path = new StringBuilder(path).append(cur.val).append("->").toString();
        getPath(cur.left, path);
        getPath(cur.right, path);
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        getPath(root, "");
        return res;
    }

    // 递归 回溯
    private void traverse(TreeNode cur, List<String> res, List<Integer> paths) {
        if (cur == null)
            return;
        if (cur.left == null && cur.right == null) {
            StringBuilder pathStr = new StringBuilder();
            for (int i = 0; i < paths.size(); ++i) {
                pathStr.append(paths.get(i)).append("->");
            }
            pathStr.append(cur.val);
            res.add(pathStr.toString());
        }
        if (cur.left != null) {
            paths.add(cur.val);
            traverse(cur.left, res, paths);
            paths.remove(paths.size() - 1); // 回溯
        }
        if (cur.right != null) {
            paths.add(cur.val);
            traverse(cur.right, res, paths);
            paths.remove(paths.size() - 1); // 回溯
        }
    }
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        traverse(root, res, paths);
        return res;
    }
}
