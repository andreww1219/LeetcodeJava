package Classic150.ArrayAndString;


import java.util.Arrays;

// 分发糖果
public class Solution135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        // 从左往右刷
        for (int i = 1; i < len; ++i)
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        // 从右往左刷
        // 统计总和
        int sum = candies[len - 1];
        for (int i = len - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            sum += candies[i];
        }
        return sum;
    }
}
