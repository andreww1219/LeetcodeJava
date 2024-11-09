package SuiXiangLu.Greedy;

import java.util.*;

// K次取反后最大化的数组和
public class Solution1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 按绝对值降序
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i)
            list.add(nums[i]);
        list.sort((num1, num2)->Math.abs(num2) - Math.abs(num1));
        // 取反
        int times = 0;
        for (int i = 0; i < list.size(); ++i) {
            if (times < k && list.get(i) < 0) {
                list.set(i, list.get(i) * -1);
                times++;
            }else if (times == k){
                break;
            }
        }
        // 用光取反次数
        if ((k - times) % 2 == 1) list.set(list.size() - 1, list.get(list.size() - 1) * -1);
        // 求和
        int sum = 0;
        for (int i = 0; i < list.size(); ++i)
            sum += list.get(i);
        return sum;
    }
}
