package Classic150.ArrayAndString;


// 跳跃游戏II
public class Solution45 {
    public int jump(int[] nums) {
        int len = nums.length;
        // now为当前位置，far为最远位置，step为步数，end为当前步数最远距离
        int now = 0, far = 0, step = 0, end = 0;
        while (now < len - 1) {
            far = Math.max(far, now + nums[now]);
            if (now == end) {
                step++;
                end = far;
            }
            now++;
        }
        return step;
    }
}
