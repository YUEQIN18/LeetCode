package String;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
        }
        for (int i = 0; i < minLength; i++) {
            boolean isCommon = true;
            char pre = 0;
            for (String s : strs) {
                char c = s.charAt(i);
                if (pre != 0 && pre != c) {
                    isCommon = false;
                }
                pre = c;
            }
            if (isCommon) {
                res.append(pre);
            } else {
                return res.toString();
            }
        }
        return res.toString();
    }
}
