package Classic150.Backtrace;


import java.util.ArrayList;
import java.util.List;

// 全排列
public class Solution46 {
    List<List<Integer>> result = new ArrayList<>();

    private void dfs(int[] nums, List<Integer> arr, boolean[] vis) {
        if (arr.size() == nums.length) {
            result.add(new ArrayList<>(arr));
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (vis[i]) continue;;
            vis[i] = true;
            arr.add(nums[i]);
            dfs(nums, arr, vis);
            vis[i] = false;
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), vis);
        return result;
    }
}
