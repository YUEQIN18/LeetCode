package TrieTree;

import javafx.beans.binding.ObjectExpression;

import java.util.Objects;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 */
public class Solution211 {
    static class WordDictionary {

        private boolean end;

        private WordDictionary[] next;
        public WordDictionary() {
            this.end = false;
            this.next = new WordDictionary[26];
        }

        public void addWord(String word) {
            if (Objects.isNull(word) || word.isEmpty()) return;
            WordDictionary cur = this;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new WordDictionary();
                }
                cur = cur.next[c - 'a'];
            }
            cur.end = true;
        }

        public boolean search(String word) {
            if (Objects.isNull(word) || word.isEmpty()) return false;
            return dfs(word, this, 0);
        }

        public boolean dfs(String s, WordDictionary cur, int index) {
            int n = s.length();
            if (n == index) return cur.end;
            char c = s.charAt(index);
            if (c == '.') {
                // 遍历所有可能
                for (int i = 0; i < 26; i++) {
                    if (cur.next[i] != null && dfs(s, cur.next[i], index + 1)) return true;
                }
                return false;
            } else {
                if (cur.next[c - 'a'] == null) return false;
                return dfs(s, cur.next[c - 'a'], index + 1);
            }
        }
    }
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
    }
}
