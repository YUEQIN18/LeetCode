package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class Solution228 {
    public  List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length) {
                int end = nums[i];
                if (start == end) {
                    res.add(String.valueOf(end));
                } else  {
                    res.add(start + "->" + end);
                }
            }
            if (i + 1 < nums.length && nums[i+1] != nums[i] + 1) {
                int end = nums[i];
                if (start == end) {
                    res.add(String.valueOf(end));
                } else  {
                    res.add(start + "->" + end);
                }
                start = nums[i+1];
            }
        }
        return res;
    }
}
