package Classic150.SlideWindow;

import org.junit.Test;

import java.util.*;

// 串联所有单词的子串
public class Solution30 {
    @Test
    public void test() {
        String s = "a";
        String[] words = {"a"};
        List<Integer> ans = findSubstring(s, words);
        for (Integer i: ans) System.out.print(i + " ");
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int wordNum = words.length, wordLen = words[0].length();
        int lenS = s.length();
        List<Integer> ans = new ArrayList<>();
        for (int offset = 0; offset < wordLen; ++offset) {
            if (offset + wordNum * wordLen > lenS)
                break;
            Map<String, Integer> record = new HashMap<>();
            for (String word: words)
                record.put(word, record.getOrDefault(word, 0) - 1);
            // 初始化滑动窗口
            int start = offset, end = start;
            for (int i = 0; i < wordNum; ++i) {
                end += wordLen;
                String substr = s.substring(end - wordLen, end);
                record.put(substr, record.getOrDefault(substr, 0) + 1);
                if (record.get(substr) == 0) record.remove(substr);
            }
            if (record.isEmpty())
                ans.add(start);
            // 移动滑动窗口
            while (end + wordLen <= lenS) {
                // 左边界移动
                String substr = s.substring(start, start + wordLen);
                record.put(substr, record.getOrDefault(substr, 0) - 1);
                if (record.get(substr) == 0) record.remove(substr);
                start += wordLen;
                // 右边界移动
                substr = s.substring(end, end + wordLen);
                record.put(substr, record.getOrDefault(substr, 0) + 1);
                if (record.get(substr) == 0) record.remove(substr);
                end += wordLen;
                // 判断是否合法
                if (record.isEmpty())
                    ans.add(start);
            }
        }
        return ans;
    }
}
