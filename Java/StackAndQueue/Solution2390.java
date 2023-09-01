package StackAndQueue;

import java.util.*;

/**
 * 2390. 从字符串中移除星号
 */
public class Solution2390 {
    public String removeStars(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!q.isEmpty() && "*".equals(String.valueOf(c))) {
                q.pollLast();
            } else {
                q.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        q.forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2390 solution2390 = new Solution2390();
        String s = solution2390.removeStars("leet**cod*e");
        System.out.println(s);
    }
}
