package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class Solution205 {
    // 这道题是一个双向映射，普通的map是一个单向映射，所以我们用两个map然后比较他们的映射是否相同就可以了
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int length = s.length();
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (s2t.containsKey(x) && s2t.get(x) != y || t2s.containsKey(y) && t2s.get(y) != x) return false;
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
