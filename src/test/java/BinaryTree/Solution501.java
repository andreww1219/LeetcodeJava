package BinaryTree;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

// 二叉搜索树中的众数
public class Solution501 {
//    public int[] findMode(TreeNode root) {
//        int[] traverseRes = list2arr(InorderTraverse(root));
//        int maxCount = 0, curCount = 1;
//        int pre = traverseRes[0];
//        List<Integer> result = new ArrayList<>();
//        for (int i = 1; i < traverseRes.length; ++i){
//            if (traverseRes[i] == pre)
//                curCount++;
//            if (curCount == maxCount)
//                result.add(traverseRes[i]);
//            if (curCount > maxCount){
//                result = new ArrayList<>();
//                result.add(traverseRes[i]);
//                maxCount = curCount;
//            }
//        }
//        return list2arr(result);
//    }
//    private List<Integer> InorderTraverse(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> traverseResult = new ArrayList<>();
//        if (root != null) stack.push(root);
//        while (!stack.empty()) {
//            TreeNode node = stack.pop();
//            if (node != null) {
//                if (node.right != null) stack.push(root.right);
//                stack.push(node);
//                stack.push(null);
//                if (node.left != null) stack.push(root.left);
//            } else {
//                node = stack.pop();
//                traverseResult.add(node.val);
//            }
//        }
//        return traverseResult;
//    }
//    private int[] list2arr(List<Integer> list) {
//        int size = list.size();
//        int[] arr = new int[size];
//        for (int i = 0; i < size; ++i)
//            arr[i] = list.get(i);
//        return arr;
//    }

    // 迭代
    public int[] findMode1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        if (root != null) stack.push(root);
        int maxCount = 0, curCount = 0;
        TreeNode pre = null;
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                node = stack.pop();
                if (pre == null) {
                    resultList.add(node.val);
                    curCount = 1;
                } else if (pre.val == node.val){
                    curCount++;
                } else {
                    curCount = 1;
                }
                if (curCount == maxCount){
                    resultList.add(node.val);
                }else if (curCount > maxCount) {
                    resultList.clear();
                    resultList.add(node.val);
                    maxCount = curCount;
                }
                pre = node;
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; ++i)
            result[i] = resultList.get(i);
       return result;
    }


    List<Integer> resultList = new ArrayList<>();
    int maxCount = 0, curCount = 0;
    TreeNode pre = null;
    public int[] findMode2(TreeNode root){
        if(root != null)
            traverse(root);
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; ++i)
            result[i] = resultList.get(i);
        return result;
    }
    private void traverse(TreeNode root) {
        if (root.left != null)
            findMode2(root.left);
        if (pre == null){
            resultList.add(root.val);
            curCount = 1;
        } else if (pre.val == root.val) {
            curCount++;
        } else {
            curCount = 1;
        }

        if (curCount == maxCount) {
            resultList.add(root.val);
        } else if (curCount > maxCount) {
            resultList.clear();
            resultList.add(root.val);
            maxCount = curCount;
        }
        pre = root;
        if (root.right != null)
            findMode2(root.right);
    }
}
