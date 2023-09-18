package BitOperation;

/**
 * 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 */
public class Solution190 {
    // 方法一：遍历法
    public int reverseBits(int n) {
        int res = 0;
        for (int i =0 ; i < 32; i++) {
            // 每次循环中，先用 n & 1 取n的最低位，然后左移相应的位数
            // 再用 或运算 把这一位的值赋值给res
            // 最后n要右移一位，保证每次只取最低位即可
            // >>>是逻辑右移，高位补0； >>是算术右移，正数高位补0，负数高位补1；对这道题来说，因为是无符号二进制，应使用>>>
            res |= (n & 1) << (31 - i);
            n = n >>> 1;
        }
        return res;
    }
    // 方法二：位运算分治
    public int reverseBits2(int n) {
        int M1 = 0x55555555; // 01010101010101010101010101010101
        int M2 = 0x33333333; // 00110011001100110011001100110011
        int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
        int M8 = 0x00ff00ff; // 00000000111111110000000011111111
        n = n >>> 1 & M1 | (n & M1) << 1; // 奇偶位交换
        n = n >>> 2 & M2 | (n & M2) << 2; // 每两位交换
        n = n >>> 4 & M4 | (n & M4) << 4; // 每四位交换
        n = n >>> 8 & M8 | (n & M8) << 8; // 每八位交换
        return n >>> 16 | n << 16; // 每16位交换
    }
}
