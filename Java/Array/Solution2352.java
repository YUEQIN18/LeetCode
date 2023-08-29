package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2352. 相等行列对
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 */
public class Solution2352 {
    public int equalPairs(int[][] grid) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                row.add(grid[i][j]);
            }
            rowMap.put(i, row);
        }
        for (int j = 0; j < grid[0].length; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                col.add(grid[i][j]);
            }
            colMap.put(j, col);
        }
        for (Map.Entry<Integer, List<Integer>> entryRow : rowMap.entrySet()) {
            List<Integer> row = entryRow.getValue();
            for (Map.Entry<Integer, List<Integer>> entryCol : colMap.entrySet()) {
                List<Integer> col = entryCol.getValue();
                if (row.equals(col)) {
                    res++;
                }
            }
        }
        return res;
    }
}
