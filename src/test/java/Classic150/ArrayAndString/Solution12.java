package Classic150.ArrayAndString;


// 整数转罗马数字
public class Solution12 {

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            while (num < nums[i]) i++;
            int times = num / nums[i];
            num %= nums[i];
            for (int j = 0; j < times; ++j)
                sb.append(romans[i]);
        }
        return sb.toString();
    }
}
