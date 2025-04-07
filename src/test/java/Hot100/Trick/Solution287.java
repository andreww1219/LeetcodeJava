package Hot100.Trick;


// 寻找重复数
public class Solution287 {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int findDuplicate(int[] nums) {
        while (true) {
            if (nums[nums[0]] == nums[0]) return nums[0];
            swap(nums, 0, nums[0]);
        }
    }
}
