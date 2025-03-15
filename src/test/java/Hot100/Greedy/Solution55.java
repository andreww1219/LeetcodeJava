package Hot100.Greedy;


import org.junit.Test;

// 跳跃游戏
public class Solution55 {
    @Test
    public void test() {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public boolean canJump(int[] nums) {
        int far = 0;
        int len = nums.length;
        for (int i = 0; i < len && i <= far; ++i) {
            far = Math.max(far, i + nums[i]);
            if (far >= len - 1) return true;
        }
        return false;
    }
}
