package Classic150.HashMap;


import java.util.HashSet;
import java.util.Set;

// 快乐数
public class Solution202 {
    // 哈希表, 超过84%
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) return false;
            else set.add(n);
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return true;
    }
    // 快慢指针, 超过100%
    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy2(int n) {
        int slow  = n, fast = n;
        while (fast != 1) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if (fast != 1 && slow == fast) return false;
        }
        return true;
    }
}
