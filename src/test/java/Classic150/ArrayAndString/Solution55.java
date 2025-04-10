package Classic150.ArrayAndString;


// 跳跃游戏
public class Solution55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int now = 0, far = 0;
        while (now <= far) {
            far = Math.max(far, nums[now] + now);
            if (far >= len - 1) return true;
            now++;
        }
        return false;
    }
}
