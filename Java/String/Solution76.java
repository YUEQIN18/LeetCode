package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        // 遍历t 记录每个字符的个数
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE; // 最终答案的长度
        int res = -1; // 最终答案
        int distance = 0;
        while (++r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {//对任何属于t的字符都记录
                count.put(c, count.getOrDefault(c, 0) + 1);
                if (count.get(c) <= map.get(c)) {//记录当前窗口的子串中属于t的字符的个数
                    distance++;
                }
            }
            while (distance == t.length() && l <= r) {
                if (r - l + 1 < len) {//更新结果
                    len = r - l + 1;
                    res = l;
                }
                if (map.containsKey(s.charAt(l))) {
                    count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                    if (count.get(s.charAt(l)) < map.get(s.charAt(l))) {
                        distance--;
                    }
                }
                ++l;
            }
        }
        return res == -1 ? "" : s.substring(res, res + len);
    }
}
