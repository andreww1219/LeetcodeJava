package Classic150.ArrayAndString;


import java.util.Random;

// 多数元素
public class Solution169 {
    public int majorityElement(int[] nums) {
        Random random = new Random();
        int len = nums.length;
        while (true) {
            int chosen = nums[random.nextInt(len)];
            int cnt = 0;
            for (int i = 0; i < len; ++i) {
                if (nums[i] == chosen) cnt++;
                if (cnt >= (len + 1) / 2) return chosen;
            }
        }
    }
}
