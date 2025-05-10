package Classic150.DirectoryTree;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 单词搜索II
public class Solution212 {
    class SolutionStandard {
        class Trie {
            boolean exist;
            Trie[] children;
            String word;
            private final int CHILDREN_NUM = 26;
            public Trie() {
                exist = false;
                children = new Trie[CHILDREN_NUM];
                word = "";
            }
            public void insert(String word) {
                char[] wordArr = word.toCharArray();
                int len = wordArr.length;
                Trie cur = this;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < len; ++i) {
                    int index = wordArr[i] - 'a';
                    sb.append(wordArr[i]);
                    if (cur.children[index] == null) {
                        cur.children[index] = new Trie();
                        cur.children[index].word = sb.toString();
                    }
                    cur = cur.children[index];
                }
                cur.exist = true;
            }
            public boolean search(String word) {
                char[] wordArr = word.toCharArray();
                int len = wordArr.length;
                Trie cur = this;
                for (int i = 0; i < len; ++i) {
                    int index = wordArr[i] - 'a';
                    if (cur.children[index] == null)
                        return false;
                    cur = cur.children[index];
                }
                return cur.exist;
            }
        }
        Trie trie;
        private boolean inArea(char[][] board, int row, int col) {
            return row >= 0 && row < board.length
                    && col >= 0 && col < board[0].length;
        }
        private void dfs(Trie cur, char[][] board, boolean[][] vis,
                         int row, int col, Set<String> ans) {
            if (!inArea(board, row, col) || vis[row][col]) return;
            vis[row][col] = true;
            int index = board[row][col] - 'a';
            Trie next = cur.children[index];
            if (next != null) {
                if (next.exist)
                    ans.add(next.word);
                dfs(next, board, vis, row + 1, col, ans);
                dfs(next, board, vis, row - 1, col, ans);
                dfs(next, board, vis, row, col + 1, ans);
                dfs(next, board, vis, row, col - 1, ans);
            }
            vis[row][col] = false;
        }
        public List<String> findWords(char[][] board, String[] words) {
            // 创建前缀树
            trie = new Trie();
            for (String word : words)
                trie.insert(word);
            // 查询前缀树
            int rows = board.length, cols = board[0].length;
            Set<String> ans = new HashSet<>();
            for (int i = 0; i < rows; ++i)
                for (int j = 0; j < cols; ++j)
                    dfs(trie, board, new boolean[rows][cols], i, j, ans);
            return new ArrayList<>(ans);
        }
    }
    class SolutionOrigin {
        // 对矩阵内所有单词建前缀树，通过21/65
        @Test
        public void test() {
            char[][] board = {
                    {'o','a','a','n'},
                    {'e','t','a','e'},
                    {'i','h','k','r'},
                    {'i','f','l','v'}
            };
            String[] words = {"oath","pea","eat","rain"};
            System.out.println(findWords(board, words));
        }
        class Trie {
            boolean exist;
            Trie[] children;
            private final int CHILDREN_NUM = 26;
            public Trie() {
                exist = false;
                children = new Trie[CHILDREN_NUM];
            }
            public Trie nextLevel(char ch) {
                int childIndex = ch - 'a';
                if (this.children[childIndex] == null) {
                    this.children[childIndex] = new Trie();
                    this.children[childIndex].exist = true;
                }
                return this.children[childIndex];
            }
            public boolean search(String word) {
                char[] wordArr = word.toCharArray();
                int len = wordArr.length;
                Trie cur = this;
                for (int i = 0; i < len; ++i) {
                    int index = wordArr[i] - 'a';
                    if (cur.children[index] == null)
                        return false;
                    cur = cur.children[index];
                }
                return cur.exist;
            }
        }
        Trie trie;
        private boolean inArea(char[][] board, int row, int col) {
            return row >= 0 && row < board.length
                    && col >= 0 && col < board[0].length;
        }
        private void dfs(Trie cur, char[][] board, boolean[][] vis, int row, int col) {
            if (!inArea(board, row, col) || vis[row][col]) return;
            vis[row][col] = true;
            Trie next = cur.nextLevel(board[row][col]);
            dfs(next, board, vis, row + 1, col);
            dfs(next, board, vis, row - 1, col);
            dfs(next, board, vis, row, col + 1);
            dfs(next, board, vis, row, col - 1);
            vis[row][col] = false;
        }
        public List<String> findWords(char[][] board, String[] words) {
            // 创建前缀树
            trie = new Trie();
            int rows = board.length, cols = board[0].length;
            for (int i = 0; i < rows; ++i)
                for (int j = 0; j < cols; ++j)
                    dfs(trie, board, new boolean[rows][cols], i, j);
            // 查询前缀树
            List<String> ans = new ArrayList<>();
            for (String word : words)
                if (trie.search(word))
                    ans.add(word);
            return ans;
        }
    }
}
