package HashMap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 四数之和
public class Solution18 {
    // 朴素加一层循环
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i){
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; ++j){
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1, l = nums.length - 1;
                while (k < l){
                    Long sum = new Long(nums[i]) + nums[j] + nums[k] + nums[l];
                    if (sum == target){
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        res.add(nums[l]);
                        result.add(res);
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (k < l && nums[l] == nums[l - 1])
                            l--;
                        k++;
                        l--;
                    }else if (sum < target){
                        k++;
                    }else {
                        l--;
                    }
                }
            }// for j
        }// for i
        return result;
    }

    // 剪枝左右开弓
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 3; ++i){
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 剪枝
            if (new Long(nums[i]) + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if (new Long(nums[i]) + nums[len - 3] + nums[len - 2] + nums[len - 1] < target)
                continue;

            for (int j = i + 1; j < len - 2; ++j){
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                // 剪枝
                if (new Long(nums[i]) + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if (new Long(nums[i]) + nums[j] + nums[len - 2] + nums[len - 1] < target)
                    continue;
                int k = j + 1, l = len - 1;
                while (k < l){
                    Long sum = new Long(nums[i]) + nums[j] + nums[k] + nums[l];
                    if (sum == target){
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        res.add(nums[l]);
                        result.add(res);
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (k < l && nums[l] == nums[l - 1])
                            l--;
                        k++;
                        l--;
                    }else if (sum < target){
                        k++;
                    }else {
                        l--;
                    }
                }
            }// for j
        }// for i
        return result;
    }

}
