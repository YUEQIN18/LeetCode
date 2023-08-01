package SlidingWindow;

/*
1456. 定长子串中元音的最大数目
给你字符串 s 和整数 k 。

请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。

英文中的 元音字母 为（a, e, i, o, u）。
 */
public class Solution1456 {
    public int maxVowels(String s, int k) {
        String bag = "aeiou";
        int length = s.length();
        int res = 0;
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (bag.contains(String.valueOf(c))) {
                res++;
            }
        }
        int max = res;
        for (int i = k; i < length; i++) {
            char c = s.charAt(i);
            if (bag.contains(String.valueOf(c))) {
                res++;
            }
            char cc = s.charAt(i-k);
            if (bag.contains(String.valueOf(cc))) {
                res--;
            }
            max = Math.max(max, res);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1456 solution1456 = new Solution1456();
        System.out.println(solution1456.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
    }
}
