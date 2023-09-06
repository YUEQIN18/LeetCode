package String;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author qinyue
 * @create 2023-09-06 18:00:00
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> temp = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (temp.containsKey(c)) {
                    temp.put(c, temp.get(c) + 1);
                } else {
                    temp.putIfAbsent(c, 1);
                }
            }
            if (map.containsKey(temp)) {
                map.get(temp).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(temp, list);
            }
        }
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
