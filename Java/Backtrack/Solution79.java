package Backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Solution79 {
    private List<String> path = new LinkedList<>();

    private boolean[][] used;
    private boolean res = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, word);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col, String word) {
        if (path.size() == word.length()) {
            if (String.join("", path).equals(word)) res = true;
            return;
        }
        if (!validNum(board, row, col)) return; // 剪枝 数组越界
        if (board[row][col] != word.charAt(path.size())) return; // 剪枝 和目标不同
        if (used[row][col]) return; // 剪枝 使用过了

        path.add(String.valueOf(board[row][col]));
        used[row][col] = true;
        dfs(board, row - 1, col, word); //上
        dfs(board, row + 1, col, word); //下
        dfs(board, row, col - 1, word); //左
        dfs(board, row, col + 1, word); //右
        used[row][col] = false;
        path.remove(path.size() - 1);
    }

    private boolean validNum(char[][] board, int row, int col) {
        return 0 <= row && row < board.length && 0 <= col && col < board[0].length;
    }
}
