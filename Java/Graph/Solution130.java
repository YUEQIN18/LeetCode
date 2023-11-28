package Graph;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solution130 {
    // 这道题时要填充所有的非边界的O
    // 所以我们要遍历和边界相关的O并标记为A，然后把剩下的O填充为X
    public void solve(char[][] board) {
        int n = board.length - 1;
        int m = board[0].length - 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 遍历和标记所有边界或者与边界相邻的O
                boolean flag = i == 0 || j == 0 || i == n || j == m;
                if (flag && board[i][j] == 'O') dfs(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 标记过的边界或者与边界相邻的O应该被还原
                if (board[i][j] == 'A') board[i][j] = 'O';
                    // 剩下的O应该被填充为X
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    private void dfs(char[][] board, int r, int c) {
        if (!inArea(board, r, c)) return;
        if (board[r][c] != 'O') return;
        // 遍历过的节点改为A
        board[r][c] = 'A';

        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
    private boolean inArea(char[][] board, int r, int c) {
        return 0 <= r && r < board.length && 0 <= c && c < board[0].length;
    }
}
