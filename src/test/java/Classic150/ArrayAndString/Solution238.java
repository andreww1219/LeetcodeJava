package Classic150.ArrayAndString;


import org.junit.Test;

// 除自身以外数组的乘积
public class Solution238 {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(productExceptSelf(nums));
    }
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; ++i)
            ans[i] = ans[i - 1] * nums[i - 1];
        int rightProduct = 1;
        for (int i = len - 1; i >= 0; --i) {
            ans[i] = ans[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return ans;
    }
}
