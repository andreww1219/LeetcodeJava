package Classic150.ArrayAndString;


// 移除元素
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0, k = 0, len = nums.length;
        while (j < len) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
                k++;
            }
            j++;
        }
        return k;
    }
}
