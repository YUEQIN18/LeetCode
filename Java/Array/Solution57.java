package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int left = newInterval[0], right = newInterval[1];
        boolean inserted = false;
        for (int[] interval: intervals) {
            int l = interval[0], r = interval[1];
            if (right < l) {
                if (!inserted) {
                    res.add(new int[] {left, right});
                    inserted = true;
                }
                res.add(interval);
            } else if (r < left) {
                res.add(interval);
            } else {
                left = Math.min(left, l);
                right = Math.max(right, r);
            }
        }
        if (!inserted) {
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[res.size()][]);
    }
}
