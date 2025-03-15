package Hot100.Greedy;



// 跳跃游戏II
public class Solution45 {
    public int jump(int[] nums) {
        int end = 0;    // 该跳最远距离
        int far = 0;    // 最远距离
        int step = 0;   // 跳数
        int len = nums.length;
        for (int i = 0; i < len - 1; ++i) {
            far = Math.max(far, i + nums[i]);
            if (i == end) {
                end = far;
                step++;
            }
        }
        return step;
    }
}
