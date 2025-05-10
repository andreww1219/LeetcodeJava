package Classic150.DirectoryTree;

// 实现Trie(前缀树)
public class Solution208 {
    class Trie {
        boolean exist;
        Trie[] children;
        private final int CHILDREN_NUM = 26;
        public Trie() {
            exist = false;
            children = new Trie[CHILDREN_NUM];
        }
        public void insert(String word) {
            char[] wordArr = word.toCharArray();
            int len = wordArr.length;
            Trie cur = this;
            for (int i = 0; i < len; ++i) {
                int index = wordArr[i] - 'a';
                if (cur.children[index] == null)
                    cur.children[index] = new Trie();
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

        public boolean startsWith(String prefix) {
            char[] wordArr = prefix.toCharArray();
            int len = wordArr.length;
            Trie cur = this;
            for (int i = 0; i < len; ++i) {
                int index = wordArr[i] - 'a';
                if (cur.children[index] == null)
                    return false;
                cur = cur.children[index];
            }
            return true;
        }
    }
}
