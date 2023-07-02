/*
 * 1071. 字符串的最大公因子
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 */
class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2+str1)) return "";
        int len = gcd(str1.length(), str2.length());
        return str1.substring(0, len);
    }
    // 辗转相除法
    private int gcd(int a, int b){
       while(b != 0){
           int tmp = b;
           b = a % b;
           a = tmp;
       }
       return a;
   }
}