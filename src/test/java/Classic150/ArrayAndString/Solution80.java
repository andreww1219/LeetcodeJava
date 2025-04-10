package Classic150.ArrayAndString;


// 删除有序数组中的重复项II
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int i = 2, j = 2, len = nums.length;
        while (j < len) {
            if (nums[j] != nums[i - 2])
                nums[i++] = nums[j];
            j++;
        }
        return i;
    }
}
