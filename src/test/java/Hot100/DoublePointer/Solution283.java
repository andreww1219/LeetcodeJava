package Hot100.DoublePointer;


// 移动零
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int slow = 0, quick = 0, len = nums.length;
        while (quick < len) {
            if (nums[quick] != 0)
                nums[slow++] = nums[quick];
            quick++;
        }
        while (slow < len)
            nums[slow++] = 0;
    }
}
