package SuiXiangLu.Array;

// 有序数组的平方
public class Solution977 {

    // 双指针
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int[] res = new int[len];
        for (int index = len - 1; index >= 0; --index){
            int squareLeft = nums[left] * nums[left];
            int squareRight = nums[right] * nums[right];
            if (squareLeft < squareRight){
                res[index] = squareRight;
                right--;
            }else{
                res[index] = squareLeft;
                left++;
            }
        }
        return res;
    }
}
