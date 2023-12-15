package Backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Solution22 {
    // 这道题使用left表示(使用了几个, 用right表示)使用了几个
    private List<String> res = new ArrayList<>();
    private List<String> path = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return res;
    }

    private void dfs(int left, int right, int length) {
        if (left == length && right == length) {
            res.add(String.join("", path));
            return;
        }
        // 剪枝
        if (left < right) return;
        if (left < length) {
            path.add("(");
            dfs(left + 1, right, length);
            path.remove(path.size() - 1);
        }
        if (right < length) {
            path.add(")");
            dfs(left, right + 1, length);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis(3);
        System.out.println(strings);
    }
}
