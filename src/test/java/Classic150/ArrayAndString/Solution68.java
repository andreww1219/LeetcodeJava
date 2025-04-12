package Classic150.ArrayAndString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// 文本左右对齐
public class Solution68 {
    @Test
    public void test() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> strings = fullJustify(words, maxWidth);
        for (String str: strings)
            System.out.println(str);
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        int[] strLens = new int[len];
        for (int i = 0; i < len; ++i) strLens[i] = words[i].length();
        List<String> ans = new ArrayList<>();
        int wordLenSum = 0, wordCount = 0;      // 单词长度总和，单词数
        int startWordIndex = 0;                 //上一个单词
        int index = 0;
        while (index < len) {
            if (wordLenSum + strLens[index] + wordCount > maxWidth) {
                // 单词长度+最少空格数
                StringBuilder sb = new StringBuilder();
                if (wordCount == 1) {
                    // 单词数为1特殊处理
                    sb.append(words[startWordIndex++]);
                    sb.append(" ".repeat(Math.max(0, maxWidth - wordLenSum)));
                } else {
                    int spacesTotalLen = maxWidth - wordLenSum;
                    int gapLen = spacesTotalLen / (wordCount - 1);
                    int gapHaveExtraSpace = spacesTotalLen % (wordCount - 1);
                    for (int j = 0; j < wordCount; ++j) {
                        sb.append(words[startWordIndex++]);
                        if (j < wordCount - 1)
                            sb.append(" ".repeat(Math.max(0, gapLen)));
                        if (j < gapHaveExtraSpace)
                            sb.append(" ");
                    }
                }
                ans.add(sb.toString());
                wordLenSum = 0;
                wordCount = 0;
            } else {
                wordLenSum += strLens[index++];
                wordCount++;
            }
        }
        // 最后一个字符串
        StringBuilder sb = new StringBuilder();
        for (int i = startWordIndex; i < len; ++i) {
            sb.append(words[i]);
            if (i < len - 1) sb.append(" ");
            else sb.append(" ".repeat(maxWidth - sb.length()));
        }
        ans.add(sb.toString());
        return ans;
    }
}
