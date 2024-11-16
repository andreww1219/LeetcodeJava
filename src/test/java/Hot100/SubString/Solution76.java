package Hot100.SubString;


import org.junit.Test;

import java.util.*;

// 最小覆盖子串
public class Solution76 {
    @Test
    public void test() {
        String s = "a";
        String t = "a";
        System.out.println(minWindow1(s, t));
    }
    // 初见
    private boolean cover(Map<Character, Integer> mapS, Map<Character, Integer> mapT) {
        for (Character ch: mapT.keySet())
            if (mapS.getOrDefault(ch, 0) < mapT.get(ch))
                return false;
        return true;
    }
    public String minWindow1(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        // 初始化字符串t对应的map
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < arrT.length; ++i)
            mapT.put(arrT[i], mapT.getOrDefault(arrT[i], 0) + 1);
        // 遍历字符串s，维护一个队列，队头是覆盖子串的offset
        int offset = -1, count = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arrS.length; ++i) {
            if (mapT.containsKey(arrS[i])) {
                mapS.put(arrS[i], mapS.getOrDefault(arrS[i], 0) + 1);
                deque.addLast(i);
            }
            while (!deque.isEmpty() &&
                    mapS.get(arrS[deque.peekFirst()]) > mapT.get(arrS[deque.peekFirst()])) {
                int first = deque.peekFirst();
                mapS.put(arrS[first], mapS.get(arrS[first]) - 1);
                deque.pollFirst();
            }

            if (i < arrT.length - 1) continue;
            if (cover(mapS, mapT) && deque.peekLast() - deque.peekFirst() + 1 < count) {
                count = deque.peekLast() - deque.peekFirst() + 1;
                offset = deque.peekFirst();
            }
        }
        return offset == -1 ? "" : String.valueOf(arrS, offset, count);
    }
    // 标准题解 滑动窗口
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> dest = new HashMap<>();

    public String minWindow2(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        // 初始化字符串t对应的map
        for (int i = 0; i < arrT.length; ++i)
            ori.put(arrT[i], ori.getOrDefault(arrT[i], 0) + 1);
        // 滑动窗口
        int offset = -1, count = Integer.MAX_VALUE;
        int l = 0, r = -1;
        while (r < arrS.length) {
            r++;
            if (r < arrS.length && ori.containsKey(arrS[r]))
                dest.put(arrS[r], dest.getOrDefault(arrS[r], 0) + 1);
            while (check() && l <= r) {
                if (count > r - l + 1) {
                    count = r - l + 1;
                    offset = l;
                }
                if (ori.containsKey(arrS[l]))
                    dest.put(arrS[l], dest.getOrDefault(arrS[l], 0) - 1);
                l++;
            }
        }
        return offset == -1 ? "" : String.valueOf(arrS, offset, count);
    }
    private boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            if (dest.getOrDefault(key, 0) < (Integer) entry.getValue())
                return false;
        }
        return true;
    }
}
