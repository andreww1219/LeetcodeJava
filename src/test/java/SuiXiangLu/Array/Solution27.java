package SuiXiangLu.Array;

import org.junit.Test;
//  移除元素

public class Solution27 {
    @Test
    public void test() {
        int[] arr = {0,1,2,2,3,0,4,2};
        int target = 2;
        System.out.println(removeElement1(arr, target));
    }

    // 快慢指针
    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        int i = 0, j = 0;
        for (; i < len; ++i){
            if (nums[i] != val){
                nums[j] = nums[i];
                ++j;
            }
        }
//        // test
//        for (int num: nums)
//            if (num == val)
//                break;
//            else
//                System.out.println(num);
        return j;
    }

    // 标准题解（快慢指针）
    public int removeElement2(int[] nums, int val){
        int slowIndex = 0, len = nums.length;
        for (int fastIndex = 0; fastIndex < len; ++fastIndex){
            if (nums[fastIndex] != val)
                nums[slowIndex++] = nums[fastIndex];
        }
        return slowIndex;
    }
}
