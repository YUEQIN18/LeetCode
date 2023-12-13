package TrieTree;

import java.util.Objects;

/**
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Solution208 {

    /**
     * 总结
     * 通过以上介绍和代码实现我们可以总结出 Trie 的几点性质：
     * <p>
     * Trie 的形状和单词的插入或删除顺序无关，也就是说对于任意给定的一组单词，Trie 的形状都是唯一的。
     * <p>
     * 查找或插入一个长度为 L 的单词，访问 next 数组的次数最多为 L+1，和 Trie 中包含多少个单词无关。
     * <p>
     * Trie 的每个结点中都保留着一个字母表，这是很耗费空间的。如果 Trie 的高度为 n，字母表的大小为 m，最坏的情况是 Trie 中还不存在前缀相同的单词，
     * 那空间复杂度就为 O(m^n)。
     * <p>
     * 最后，关于 Trie 的应用场景，希望你能记住 8 个字：一次建树，多次查询。
     */
     class Trie {

        private boolean end;

        private Trie[] next;

        public Trie() {
            this.end = false;
            this.next = new Trie[26];
        }

        public void insert(String word) {
            if (Objects.isNull(word) || word.isEmpty()) return;
            Trie cur = this;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Trie();
                }
                cur = cur.next[c - 'a'];
            }
            cur.end = true;
        }

        public boolean search(String word) {
            if (Objects.isNull(word) || word.isEmpty()) return false;
            Trie cur = this;
            for (char c : word.toCharArray()) {
                cur = cur.next[c - 'a'];
                if (cur == null) return false;
            }
            return cur.end;
        }

        public boolean startsWith(String prefix) {
            if (Objects.isNull(prefix) || prefix.isEmpty()) return false;
            Trie cur = this;
            for (char c : prefix.toCharArray()) {
                cur = cur.next[c - 'a'];
                if (cur == null) return false;
            }
            return true;
        }
    }

}
