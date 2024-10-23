package BinaryTree;

import java.util.Map;

// 最大二叉树
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length -1);
    }
    private  TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (end - start < 0)
            return null;
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = start; i <= end; ++i){
            if (max < nums[i]){
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return root;
    }
}
