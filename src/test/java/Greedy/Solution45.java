package Greedy;

// 跳跃游戏 II
public class Solution45 {
    // 初见
    public int jump1(int[] nums) {
        return jump1(nums, 0);
    }
    public int jump1(int[] nums, int index) {
        if (index == nums.length - 1)
            return 0;
        int del = 1, maxDel = 0, maxDis = Integer.MIN_VALUE;
        while (del <= nums[index]) {
            if (index + del == nums.length - 1)
                return 1;
            int dis = del + nums[index + del];
            if (dis > maxDis) {
                maxDis = dis;
                maxDel = del;
            }
            del++;
        }
        return 1 + jump1(nums, index + maxDel);
    }

    // 标准题解
    public int jump2(int[] nums) {
        if (nums.length == 1)
            return 0;
        int curDis = 0, nextDis = 0, cnt = 0;
        for (int i = 0; i <= nextDis; ++i) {
            nextDis = Math.max(nextDis, nums[i] + i);
            if (nextDis >= nums.length - 1) {
                ++cnt;
                break;
            }
            if (i == curDis) {
                curDis = nextDis;
                ++cnt;
            }
        }
        return cnt;
    }
}
