package Graph;

import java.util.*;

/**
 * 127. 单词接龙
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 *
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 1; // 因为要返回整个序列的长度 所以起点是1
        Set<String> set = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                System.out.println(cur + ": " + step);
                if (cur.equals(endWord)) return step;
                // 找到下一个 和 cur只差一个字母的字符串
                List<String> nextList = checkNextValidWord(cur, wordList);
                nextList.forEach(s -> {
                    if (!set.contains(s)) {
                        queue.offer(s);
                        set.add(s);
                    }
                });
            }
            step++;
        }
        return 0;
    }

    private List<String> checkNextValidWord(String cur, List<String> wordList) {
        // 从list里选 没有被遍历过的 和 cur只差一个字母的字符串
        List<String> res = new ArrayList<>();
        char[] curArray = cur.toCharArray();
        int length = cur.length();
        for (String word : wordList) {
            int diff = 0;
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < length; i++) {
                if (curArray[i] != wordArray[i]) diff++;
            }
            if (diff == 1) res.add(word);
        }
        return res;
    }
}
