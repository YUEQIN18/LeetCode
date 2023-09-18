package String;

/**
 * 680. 验证回文串 II
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 */
public class Solution680 {
    // 思路比较简单的双指针法
    // 不同的地方在于有一次删除字符的机会，所以遇到左右指针的字符不一致时，
    // 可以尝试[start+1,end]或者[start, end-1]是否是回文
    private int magic = 1;

    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0 || end < 0) return false;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (magic > 0) {
                    magic--;
                    return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
                } else {
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution680 solution680 = new Solution680();
        System.out.println(solution680.validPalindrome("abc"));
    }
}
