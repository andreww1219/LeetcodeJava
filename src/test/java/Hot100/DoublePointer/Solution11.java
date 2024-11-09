package Hot100.DoublePointer;


// 盛最多水的容器
public class Solution11 {
    // TLE 56/63
    public int maxArea1(int[] height) {
        int res = 0, len = height.length;
        for (int i = 0; i < len; ++i)
            for (int j = i + 1; j < len; ++j)
                res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
        return res;
    }
    // 标准题解
    public int maxArea2(int[] height) {
        int res = 0, len = height.length;
        int l = 0, r = len - 1;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }
}
