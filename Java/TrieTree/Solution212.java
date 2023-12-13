package TrieTree;

import java.util.*;

/**
 * 212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 */
public class Solution212 {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右移动的方向
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>(); // 去重
        TrieNode root = buildTrie(words); // 构建字典树
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n]; // 记录棋盘上的元素是否访问过
        StringBuilder result = new StringBuilder(); // 记录沿途的元素
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 从每个元素开始遍历
                dfs(res, result, board, i, j, root, visited);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(Set<String> set, StringBuilder result, char[][] board, int i, int j, TrieNode node, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || node.next[board[i][j] - 'a'] == null) return;
        // 记录当前字符
        result.append(board[i][j]);

        // 如果有结束字符，加入结果集中
        if (node.next[board[i][j] - 'a'].end) {
            set.add(result.toString());
        }

        // 记录当前元素已访问
        visited[i][j] = true;

        // 按四个方向去遍历
        for (int[] dir : dirs) {
            dfs(set, result, board, i + dir[0], j + dir[1], node.next[board[i][j] - 'a'], visited);
        }

        // 还原状态
        visited[i][j] = false;
        result.deleteCharAt(result.length() - 1);
    }

    class TrieNode {
        private boolean end = false;
        private TrieNode[] next = new TrieNode[26];
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            char[] arr = word.toCharArray();
            TrieNode curr = root;
            for (char c : arr) {
                if (curr.next[c - 'a'] == null) {
                    curr.next[c - 'a'] = new TrieNode();
                }
                curr = curr.next[c - 'a'];
            }
            curr.end = true;
        }
        return root;
    }
}
