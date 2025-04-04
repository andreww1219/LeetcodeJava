package Hot100.Trick;


// 颜色分类
public class Solution75 {
    // 两次遍历
    public void sortColors1(int[] nums) {
        int len = nums.length;
        int cnt0 = 0, cnt2 = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == 0) cnt0++;
            else if (nums[i] == 2) cnt2++;
        }
        for (int i = 0; i < len; ++i) {
            if (i < cnt0) nums[i] = 0;
            else if (i < len - cnt2) nums[i] = 1;
            else nums[i] = 2;
        }
    }
    // 一次遍历
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors2(int[] nums) {
        int len = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1)    // 如果p0的位置是1
                    swap(nums, i, p1);
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            }
        }
    }
}
