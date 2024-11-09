package Hot100.DoublePointer;

import org.junit.Test;


// 接雨水
public class Solution42 {
    @Test
    public void test() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) return 0;
        // maxLeft 和 maxRight 分别表示 i 本身及左/右 的最大高度
        // 那么 maxLeft[0] = height[0] maxRight[len - 1] = height[len - 1]
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        maxLeft[0] = height[0];
        for (int i = 1; i < len; ++i)
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; -- i)
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);

        int sum = 0;
        for (int i = 1; i < len - 1; ++i)
            sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
        return sum;
    }
}
