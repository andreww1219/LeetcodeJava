package Hot100.GraphTheory;


// 实现 Trie (前缀树)
public class Solution208 {
    class Trie {
        Trie[] children;
        boolean exist;
        public Trie() {
            children = new Trie[26];
            exist = false;
        }

        public void insert(String word) {
            char[] wordArr = word.toCharArray();
            Trie cur = this;
            for (int i = 0; i < wordArr.length; ++i) {
                char ch = wordArr[i];
                int index = ch - 'a';
                if (cur.children[index] == null) cur.children[index] = new Trie();
                cur = cur.children[index];
            }
            cur.exist = true;
        }

        public boolean search(String word) {
            char[] wordArr = word.toCharArray();
            Trie cur = this;
            for (int i = 0; i < wordArr.length; ++i) {
                char ch = wordArr[i];
                int index = ch - 'a';
                if (cur.children[index] == null)
                    return false;
                cur = cur.children[index];
            }
            return cur.exist;
        }

        public boolean startsWith(String prefix) {
            char[] wordArr = prefix.toCharArray();
            Trie cur = this;
            for (int i = 0; i < wordArr.length; ++i) {
                char ch = wordArr[i];
                int index = ch - 'a';
                if (cur.children[index] == null)
                    return false;
                cur = cur.children[index];
            }
            return true;
        }
    }
}
