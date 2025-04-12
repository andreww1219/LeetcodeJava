package Classic150.DoublePointer;


// 盛最多水的容器
public class Solution11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}
