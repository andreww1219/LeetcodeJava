package Classic150.HashMap;


import java.util.HashMap;
import java.util.Map;

// 存在重复元素II
public class Solution219 {
    private final int NEVER_OCCUR = -0x7FFFF;
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> lastOccur = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (i - lastOccur.getOrDefault(nums[i], NEVER_OCCUR) <= k)
                return true;
            lastOccur.put(nums[i], i);
        }
        return false;
    }
}
