package String;
/**
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 */
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();
        while(p1 < word1.length() && p2 < word2.length()) {
            sb.append(word1.charAt(p1));
            sb.append(word2.charAt(p2));
            p1++;
            p2++;
        }
        if (word1.length() > word2.length()) {
            sb.append(word1.substring(p1, word1.length()));
        } else {
            sb.append(word2.substring(p2, word2.length()));
        }
        return sb.toString();
    }
}
