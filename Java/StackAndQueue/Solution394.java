package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class Solution394 {

    // 使用递归法，相比直接使用栈然后遍历 会更简单好理解
    private int i;
    
    public String decodeString(String s) {
        i = 0;
        return decode(s);
    }
    
    private String decode(String s) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == ']') {
                break; //结束递归
            } else if (c == '[') {
                String temp = decode(s);
                for (int i = 0; i < num; i++) {
                    sb.append(temp);
                }
                num = 0;
            } else if (c >= '0' && c <= '9') {
                num = num * 10  + c - '0'; // 如果num是两位数或者三位数，需要*10
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        String s = solution394.decodeString("3[a]2[bc]");
        System.out.println(s);
    }
}
