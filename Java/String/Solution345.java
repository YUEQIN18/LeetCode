package String;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 345. 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 */
public class Solution345 {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] array = s.toCharArray();
        while(l <= r) {
            if (isVowels(array[l]) && isVowels(array[r])) {
                char temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                r--;
                l++;
            } else if (isVowels(array[l]) && !isVowels(array[r])) {
                r--;
            } else if (!isVowels(array[l]) && isVowels(array[r])) {
                l++;
            } else {
                r--;
                l++;
            }
        }
        return new String(array);
    }
    private boolean isVowels(char c) {
        List<Character> res = Stream.of('a','e','i','o','u','A','E','I','O','U').collect(Collectors.toList());
        return res.contains(c);
    }
    public static void main(String[] args) {
        Solution345 s = new Solution345();
        System.out.println(s.reverseVowels("hello"));
    }
}
