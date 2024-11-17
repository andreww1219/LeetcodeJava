package Hot100.Array;


// 除自身以外数组的乘积
public class Solution238 {
    // 初见
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] aft = new int[len];
        pre[0] = 1;
        aft[len - 1] = 1;
        for (int i = 1; i < len; ++i)
            pre[i] = pre[i - 1] * nums[i - 1];
        for (int i = len - 2; i >= 0; --i)
            aft[i] = aft[i + 1] * nums[i + 1];
        int[] answer = new int[len];
        for (int i = 0; i < len; ++i)
            answer[i] = pre[i] * aft[i];
        return answer;
    }
    // 空间复杂度O(1) 题解
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for (int i = 1; i < len; ++i)
            answer[i] = answer[i  -1] * nums[i - 1];
        int aft = 1;
        for (int i = len - 1; i >= 0; --i) {
            answer[i] *= aft;
            aft *= nums[i];
        }
        return answer;
    }
}
