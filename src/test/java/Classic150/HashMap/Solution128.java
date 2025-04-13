package Classic150.HashMap;


import java.util.HashSet;
import java.util.Set;

// 最长连续序列
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; ++i) set.add(nums[i]);
        int ans = 0;
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int cnt = 1, cur = num + 1;
                while (set.contains(cur)) {
                    cnt++;
                    cur++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
