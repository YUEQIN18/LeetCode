package BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }
    private void dfs(int startIndex, int n, int k) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            dfs(i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        List<List<Integer>> combine = solution77.combine(4, 2);
        System.out.println(combine);
    }
}
