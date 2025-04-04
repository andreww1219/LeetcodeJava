package Hot100.Trick;


import java.util.HashMap;
import java.util.Random;

// 多数元素
public class Solution169 {
    // 哈希表
    public int majorityElement1(int[] nums) {
        int maxCnt = 0, maxNum = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > maxCnt) {
                maxCnt = map.get(num);
                maxNum = num;
            }
        }
        return maxNum;
    }
    // 赌狗解法
    public int majorityElement2(int[] nums) {
        Random random = new Random();
        int len = nums.length;
        while (true) {
            int num = nums[random.nextInt(len)];
            int cnt = 0;
            for (int i = 0; i < len; ++i) {
                if (nums[i] == num) {
                    cnt++;
                    if (cnt >= len / 2) return num;
                }
            }
        }
    }
}
