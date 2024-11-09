package SuiXiangLu.HashMap;

import java.util.HashMap;
import java.util.Map;

// 两数之和
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i){
            if (map.get(target - nums[i]) != null){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
