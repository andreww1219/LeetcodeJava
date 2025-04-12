package Classic150.DoublePointer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            // 对i去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = len - 1;
            while (j < k) {
                // 对j,k去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < len - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);
                    ans.add(arr);
                }
                if (sum < 0) j++;
                else k--;
            }
        }
        return ans;
    }
}
