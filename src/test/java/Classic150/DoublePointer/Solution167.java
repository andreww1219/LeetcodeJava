package Classic150.DoublePointer;


// 两数之和II-输入有序数组
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0, r = len - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target)
                return new int[]{l, r};
            else if (numbers[l] + numbers[r] < target)
                l++;
            else
                r--;
        }
        return new int[2];
    }
}
