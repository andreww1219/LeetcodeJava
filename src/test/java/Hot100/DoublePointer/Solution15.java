package Hot100.DoublePointer;


import java.util.*;

// 三数之和
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            // 对 i 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                   List<Integer> list = new ArrayList<>();
                   list.add(nums[i]); list.add(nums[l]); list.add(nums[r]);
                   res.add(list);
                   // 对 l r 去重
                   while (l + 1 < len && nums[l] == nums[l + 1]) l++;
                   while (r - 1 > i && nums[r] == nums[r - 1]) r--;
                   l++; r--;
                }
            }
        }
        return res;
    }
}
