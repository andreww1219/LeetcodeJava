package SuiXiangLu.Array;

import org.junit.Test;

// 长度最小的子数组

public class Solution209 {

    @Test
    public void test(){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen1(target, nums));
    }
    private int IMPOSSIBLE_RES = 1000 * 1000;

    // 滑动窗口（初见）
    public int minSubArrayLen1(int target, int[] nums) {
        int len = nums.length;
        int res = IMPOSSIBLE_RES, sum = 0;
        int slow = 0, fast = 0;
        while (slow < len) {
            if(sum >= target){
                res = Integer.min(res, fast - slow);
                sum -= nums[slow++];
            }else if (fast < len){
                sum += nums[fast++];
            }else{
                break;
            }
        }
        return res == IMPOSSIBLE_RES? 0: res;
    }
    // 滑动窗口（参考题解）

    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int res = IMPOSSIBLE_RES, sum = 0;
        int slow = 0;
        for (int fast = 0; fast < len; ++fast){
            sum += nums[fast];
            while (sum >= target){
                int subArrLen = fast - slow + 1;
                res = res < subArrLen? res: subArrLen;
                sum -= nums[slow++];
            }
        }
        return res == IMPOSSIBLE_RES? 0: res;
    }
}
