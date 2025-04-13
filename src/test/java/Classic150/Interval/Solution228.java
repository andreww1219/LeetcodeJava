package Classic150.Interval;


import java.util.ArrayList;
import java.util.List;

// 汇总区间
public class Solution228 {
    private String generateInterval(int l, int r) {
        if (l == r) return String.valueOf(l);
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        sb.append("->");
        sb.append(r);
        return sb.toString();
    }
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        if (len == 0) return new ArrayList<>();
        int l = nums[0], r = nums[0];
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < len; ++i) {
            if (nums[i] != nums[i - 1] + 1) {
                ans.add(generateInterval(l, r));
                l = r = nums[i];
            } else r = nums[i];
        }
        ans.add(generateInterval(l, r));
        return ans;
    }
}
