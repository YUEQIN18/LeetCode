package DynamicPlanning;

/**
 * @author qinyue
 * @create 2024-03-25 21:24:00
 * 97. 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空
 * 子字符串
 * ：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 */
public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();
        if (n + m != l) return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        // 初始化每一行第一个 意思是 只用s1能不能构成s3
        for (int i = 1; i <= n && dp[i-1][0]; i++) dp[i][0] = c1[i - 1] == c3[i - 1];
        // 初始化每一列第一个 意思是 只用s2能不能构成s3
        for (int j = 1; j <= m && dp[0][j-1]; j++) dp[0][j] = c2[j - 1] == c3[j - 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果s1[i]可以提供s3[i+j]
                if (c1[i - 1] == c3[i + j - 1]) dp[i][j] |= dp[i-1][j];
                // 如果s2[j]可以提供s3[i+j]
                if (c2[j - 1] == c3[i + j - 1]) dp[i][j] |= dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}
