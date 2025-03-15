package Hot100.DynamicProgramming;


import java.util.ArrayList;
import java.util.List;

// 杨辉三角
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 1; row <= numRows; ++row) {
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < row; ++i) {
                if (i == 0 || i == row - 1) {
                    nums.add(1);
                    continue;
                }
                List<Integer> lastRow = result.get(result.size() - 1);
                nums.add(lastRow.get(i) + lastRow.get(i - 1));
            }
            result.add(nums);
        }
        return result;
    }
}
