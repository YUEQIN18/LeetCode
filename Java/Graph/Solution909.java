package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 909. 蛇梯棋
 * 给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）每一行交替方向。
 * <p>
 * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
 * <p>
 * 每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
 * <p>
 * 选定目标方格 next ，目标方格的编号符合范围 [curr + 1, min(curr + 6, n2)] 。
 * 该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
 * 传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
 * 当玩家到达编号 n2 的方格时，游戏结束。
 * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n2 的方格上没有蛇或梯子。
 * <p>
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
 * <p>
 * 举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。
 * 返回达到编号为 n2 的方格所需的最少移动次数，如果不可能，则返回 -1。
 */
public class Solution909 {
    // 这道题的一个难点就是二维数组坐标转换，这里还是建议将二维数组转换为一维
    public int snakesAndLadders(int[][] board) {
        int n = board.length; // n x n 的棋盘
        int length = n * n;
        int step = 0;
        Set<Integer> set = new HashSet<>(); // 记录遍历过的节点
        // 二维数组转换成一维
        int[] nums = twoForOne(board, n);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 棋盘index从 1 开始
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int curIndex = queue.poll();

                if (curIndex == length) return step;
                if (set.contains(curIndex)) continue;
                set.add(curIndex);
                // 走下一步
                for (int i = curIndex + 1; i <= Math.min(curIndex + 6, length); i++) {
                    int ladder = nums[i];
                    int next = ladder == -1 ? i : ladder;
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }

    public int[] twoForOne(int[][] board, int n) {
        int[] nums = new int[n * n + 1];
        int index = 1;
        for (int i = n - 1; i >= 0; i--) {
            //取最下方为第一行,奇数行正向,偶数行反向
            int row = n - i;
            if (row % 2 == 1) {
                for (int j = 0; j < n; j++) {
                    nums[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    nums[index++] = board[i][j];
                }
            }
        }
        for (int num : nums) System.out.print(num + " ");
        return nums;
    }

}
