package Hot100.SubString;


import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;

// 和为K的子数组
public class Solution560 {
    // 初见 复杂度O(n^2)
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        // pre[i] 表示 [0, i) 的求和
        int[] pre = new int[len + 1];
        pre[0] = 0;
        for (int i = 0; i < len; ++i)
            pre[i + 1] = nums[i] +  pre[i];

        int res = 0;
        for (int i = 0; i <= len; ++i)
            for (int j = i + 1; j <= len; ++j)
                if (pre[j] - pre[i] == k) res++;
        return res;
    }

    // 标准题解 前缀和+哈希表
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] pre = new int[len + 1];
        pre[0] = 0;
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < len; ++i) {
            pre[i + 1] = nums[i] +  pre[i];
            if (map.containsKey(pre[i + 1] - k))
                res += map.get(pre[i + 1] - k);
            map.put(pre[i + 1], map.getOrDefault(pre[i + 1], 0) + 1);
        }
        return res;
    }
}
