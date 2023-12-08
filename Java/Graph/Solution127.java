package Graph;

import java.util.*;

/**
 * 127. 单词接龙
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 */
public class Solution127 {
    public int ladderLengthV2(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> set = new HashSet<>(wordList);
        if (set.isEmpty() || !set.contains(endWord)) return 0;

        // 第 2 步：已经访问过的 word 添加到 visited 哈希表里
        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
        Set<String> visited = new HashSet<>();
        Set<String> beginVisit = new HashSet<>();
        beginVisit.add(beginWord);
        Set<String> endVisit = new HashSet<>();
        endVisit.add(endWord);

        // 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
        int step = 1;
        while (!beginVisit.isEmpty() && !endVisit.isEmpty()) {
            // 优先选择小的哈希表进行扩散, 考虑的情况更少
            if (beginVisit.size() > endVisit.size()) {
                Set<String> temp = beginVisit;
                beginVisit = endVisit;
                endVisit = temp;
            }
            // 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisit 在扩散完成以后，会成为新的 beginVisit
            Set<String> nextLevelVisit = new HashSet<>();
            for (String word : beginVisit) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char origin = charArray[i]; // 记录这个字符 之后恢复
                    // 尝试26个字母
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (origin == c) continue;
                        charArray[i] = c;
                        String next = String.valueOf(charArray);
                        // 不在wordList里 直接跳过
                        if (!set.contains(next)) continue;
                        // beginVisit和endVisit有交集 返回步数+1
                        if (endVisit.contains(next)) return step + 1;
                        if (visited.contains(next)) continue;
                        nextLevelVisit.add(next);
                        visited.add(next);
                    }
                    charArray[i] = origin; // 恢复这个字符
                }
            }
            step++;
            beginVisit = nextLevelVisit;
        }

        return 0;
    }

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
