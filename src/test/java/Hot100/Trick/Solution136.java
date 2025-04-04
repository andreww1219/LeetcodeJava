package Hot100.Trick;


// 只出现一次的数字
public class Solution136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num: nums) single ^= num;
        return single;
    }
}
