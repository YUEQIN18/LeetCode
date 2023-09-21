package Array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 274. H 指数
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，
 * 一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * 示例 1：
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 */
public class Solution274 {
    // 二分查找法：在 有序数组 中查找符合条件的某个数（或者它的下标），可以使用二分查找。
    // h 指数想说的是这样一件事情：一个人的论文根据被引用的次数，有一个阈值（分水岭，就是这里的 h），引用次数大于等于这个阈值的论文是「高引用论文」。
    // 所以理解 h 指数的时候可以把一个研究者的论文被引用的次数 按照升序排序。题目其实要我们找的是一条分割线，这条分割线的含义是：
    // 分割线右边的所有论文的引用次数都很高，并且：分割线右边的最少引用次数 >= 分割线右边的论文篇数。
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = len;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            // 找出有多少篇论文的引用次数大于mid
            int count = 0;
            for (int c : citations) {
                if (c >= mid) {
                    count++;
                }
            }
            // count >= mid 这时的h 至少是mid, 答案就落在[mid, right]里，所以移动left
            if (count >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return len - left;
    }
}
