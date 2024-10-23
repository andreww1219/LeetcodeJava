package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 快乐数
public class Solution202 {

    // 初见
    public boolean isHappy1(int n) {
        Set<Integer> record = new HashSet<>();
        record.add(n);
        while (true) {
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (sum == 1)
                return true;
            if (record.contains(sum))
                return false;
            record.add(sum);
            n = sum;
        }
    }

    // 标准题解
    public boolean isHappy2(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)){
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n){
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
