package String;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) return false;
        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char x = pattern.charAt(i);
            String y = strings[i];
            if (p2s.containsKey(x) && !p2s.get(x).equals(y) || s2p.containsKey(y) && !s2p.get(y).equals(x)) return false;
            p2s.put(x, y);
            s2p.put(y, x);
        }
        return true;
    }
}
