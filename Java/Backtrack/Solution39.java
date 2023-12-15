package Backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class Solution39 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new LinkedList<>();
    private Integer sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }
    private void dfs(int[] nums, int target, int startIndex) {
        if (sum.compareTo(target) > 0) return;
        if (sum.equals(target)) {
            res.add(new LinkedList<>(path));
            return;
        }
        // 组合问题需要startIndex 因为[2, 2, 3] 与 [2, 3, 2] 视为相同列表，我们需要按照顺序搜索
        for (int i = startIndex; i < nums.length; i++) {
            sum += nums[i];
            path.add(nums[i]);
            dfs(nums, target, i);
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }
}
