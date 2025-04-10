package Classic150.ArrayAndString;


import java.util.HashSet;
import java.util.Set;

// 删除有序数组中的重复项
public class Solution26 {
    // 超越10%
    public int removeDuplicates1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0, len = nums.length;
        while (j < len) {
            if (!set.contains(nums[j])) {
                nums[i++] = nums[j];
                set.add(nums[j]);
            }
            j++;
        }
        return set.size();
    }
    public int removeDuplicates2(int[] nums) {
        int i = 1, j = 1, k = 1, len = nums.length;
        while (j < len) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
                k++;
            }
            j++;
        }
        return k;
    }
}
