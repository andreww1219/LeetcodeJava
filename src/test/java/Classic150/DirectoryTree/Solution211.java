package Classic150.DirectoryTree;


import java.util.Deque;
import java.util.LinkedList;

// 添加与搜索单词-数据结构设计
public class Solution211 {
    class WordDictionary {
        private static final int CHILDREN_NUM = 26;
        WordDictionary[] children;
        int depth;
        boolean exist;

        public WordDictionary() {
            children = new WordDictionary[CHILDREN_NUM];
            exist = false;
            depth = -1;
        }

        public void addWord(String word) {
            WordDictionary cur = this;
            char[] wordArr = word.toCharArray();
            int len = wordArr.length;
            for (int i = 0; i < len; ++i) {
                int childIndex = wordArr[i] - 'a';
                if (cur.children[childIndex] == null) {
                    cur.children[childIndex] = new WordDictionary();
                    cur.children[childIndex].depth = i;
                }
                cur = cur.children[childIndex];
            }
            cur.exist = true;
        }

        public boolean search(String word) {
            char[] wordArr = word.toCharArray();
            int len = wordArr.length;
            Deque<WordDictionary> deque = new LinkedList<>();
            deque.addLast(this);
            while (!deque.isEmpty()) {
                WordDictionary front = deque.pollLast();    // pollLast更快收敛
                int index = front.depth + 1;
                if (index == len) {
                    if (front.exist)
                        return true;
                    continue;
                }
                if (wordArr[index] != '.') {
                    int childIndex = wordArr[index] - 'a';
                    if (front.children[childIndex] == null)
                        continue;
                    deque.addLast(front.children[childIndex]);
                } else {
                    for (int i = 0; i < CHILDREN_NUM; ++i) {
                        if (front.children[i] != null)
                            deque.addLast(front.children[i]);
                    }
                }
            }
            return false;
        }
    }
}
