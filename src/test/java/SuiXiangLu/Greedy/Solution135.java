package SuiXiangLu.Greedy;

import org.junit.Test;

import java.util.Arrays;

// 分发糖果
public class Solution135 {
    @Test
    public void test() {
        int[] ratings = {1, 2, 2};
        System.out.println(candy1(ratings));
    }
    // 递归 过样例 47/48
    int[] candies;

    public int candy1(int[] ratings) {
        candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 0; i < candies.length; ++i)
            distribute(ratings, candies, i);
        int sum = 0;
        for (int i = 0; i < candies.length; ++i)
            sum += candies[i];
        return sum;
    }
    private void distribute(int[] ratings, int[] candies, int i) {
        if (i < 0 || i >= candies.length) return;
        if (i > 0) {
            if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
                distribute(ratings, candies, i + 1);
            } else if (ratings[i] < ratings[i - 1] && candies[i] >= candies[i - 1]) {
                candies[i - 1] = candies[i] + 1;
                distribute(ratings, candies, i - 2);
            }
        }
       if (i < ratings.length - 1) {
           if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
               candies[i] = candies[i + 1] + 1;
               distribute(ratings, candies, i - 1);
           } else if (ratings[i] < ratings[i + 1] && candies[i] >= candies[i + 1]) {
               candies[i + 1] = candies[i] + 1;
               distribute(ratings, candies, i + 2);
           }
       }
    }

    // 贪心
    public int candy2(int[] ratings) {
        candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        // 从左向右
        for (int i = 1; i < candies.length; ++i)
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        // 从右向左
        for (int i = candies.length - 2; i >= 0; --i)
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);

        int sum = 0;
        for (int i = 0; i < candies.length; ++i)
            sum += candies[i];
        return sum;
    }
}
