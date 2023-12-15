package Backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new LinkedList<>();
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        int length = nums.length;
        if (path.size() == length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
