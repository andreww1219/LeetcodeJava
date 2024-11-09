package SuiXiangLu.HashMap;

import java.util.*;

// 三数之和
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i){
            // 对 i 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);res.add(nums[j]); res.add(nums[k]);
                    result.add(res);
                    // 对 j, k 去重
                    while(j < k && nums[j] == nums[j + 1])++j;
                    while(j < k && nums[k] == nums[k - 1])--k;
                    ++j;--k;
                }else if (sum < 0){
                    ++j;
                }else{
                    --k;
                }
            }
        }
        return result;
    }
}
