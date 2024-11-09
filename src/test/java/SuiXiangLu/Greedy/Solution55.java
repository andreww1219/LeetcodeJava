package SuiXiangLu.Greedy;


import java.util.LinkedList;
import java.util.Queue;

// 跳跃游戏
public class Solution55 {
    // 暴力
    public boolean canJump1(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        vis[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index == nums.length - 1)
                return true;
            for (int i = index + 1; i <= Math.min(index + nums[index], nums.length - 1); ++i) {
                if (!vis[i]) {
                    queue.add(i);
                }
            }
        }
        return false;
    }
    // 贪心 每步找覆盖最大
    public boolean canJump2(int[] nums) {
        return canJump2(nums, 0);
    }
    public boolean canJump2(int[] nums, int index) {
        if (index == nums.length - 1)
            return true;
        int del = 1, maxDel = 0, maxDis = Integer.MIN_VALUE;
        while (index + del < nums.length && del <= nums[index]) {
            int dis = del + nums[index + del];
            if (dis > maxDis) {
                maxDis = dis;
                maxDel = del;
            }
            del++;
        }
        return (maxDis == Integer.MIN_VALUE)? false: canJump2(nums, index + maxDel);
    }

    // 贪心 标准题解 不断往前覆盖
    public boolean canJump3(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; ++i) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}
