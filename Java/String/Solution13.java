package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 */
public class Solution13 {
    // 优雅的做法
    public int romanToInt2(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            result += which(s.charAt(i));
        }
        return result;
    }

    private int which(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }

    // 朴素的做法
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            Integer v = 0;
            if (i == 0) {
                v = map.get(array[i]);
            } else if (array[i-1] == 'I' && array[i] == 'V') {
                v = map.get(array[i]) - 2 * map.get(array[i-1]);
            } else if (array[i-1] == 'I' && array[i] == 'X') {
                v = map.get(array[i]) - 2 * map.get(array[i-1]);
            } else if (array[i-1] == 'X' && array[i] == 'L') {
                v = map.get(array[i]) - 2 * map.get(array[i-1]);
            } else if (array[i-1] == 'X' && array[i] == 'C') {
                v = map.get(array[i]) - 2 * map.get(array[i-1]);
            } else if (array[i-1] == 'C' && array[i] == 'D') {
                v = map.get(array[i]) - 2 * map.get(array[i-1]);
            } else if (array[i-1] == 'C' && array[i] == 'M') {
                v = map.get(array[i]) - 2 * map.get(array[i-1]);
            } else {
                v = map.get(array[i]);
            }
            res += v;
        }
        return res;
    }
}
