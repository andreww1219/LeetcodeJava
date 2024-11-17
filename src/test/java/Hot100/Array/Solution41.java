package Hot100.Array;


import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 缺失的第一个正数
public class Solution41 {
    // 初见 时间 O(N) 空间 O(N)
    public int firstMissingPositive1(int[] nums) {
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
            while (set.contains(res))
                res++;
        }
        return res;
    }
    // 标准题解1 在原数组上做哈希 时间O(N) 空间O(1)
    @Test
    public void test() {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive2(nums));
    }
    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        // 将非正数变为 len + 1
        for (int i = 0; i < len; ++i)
            if (nums[i] <= 0)
                nums[i] = len + 1;
        // 将 [1, len] 的正数做哈希
        for (int i = 0; i < len; ++i) {
            int absVal = Math.abs(nums[i]);
            if (absVal <= len)
                nums[absVal - 1] = - Math.abs(nums[absVal - 1]);
        }
        // 遍历数组找到答案
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0)
                return i + 1;
        }
        return len + 1;
    }
    // 标准题解2 置换 时间O(N) 空间O(1)
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int firstMissingPositive3(int[] nums) {
        int len = nums.length;
        // 将 x 置换到 x - 1 的位置，每次置换都有一个数到对的位置
        // 只需要置换 [1, len] 的数
        for (int i = 0; i < len; ++i) {
            while (nums[i] >= 1 && nums[i] <= len && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        }
        for (int i = 0; i < len; ++i) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return len + 1;
    }
}
