package String;

/*
 * 443. 压缩字符串
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * 
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 */
public class Solution443 {
    public int compress(char[] chars) {
        int length = chars.length;
        if(length <= 1) return length;
        char[] res = new char[length + 10];
        int slow = 0, fast = 0, write = 0;
        while(fast < length) {
            if(fast == length - 1 || chars[fast] != chars[fast + 1]) {
                res[write++] = chars[fast];
                int count = fast - slow + 1;
                slow = fast + 1;
                fast++;
                if (count == 1) continue;
                char[] c = String.valueOf(count).toCharArray();
                for (char cc : c) {
                    res[write++] =  cc;
                }
            } else fast++;
        }
        for(int i = 0; i < write; i++) {
            chars[i] = res[i];
        }
        return write;
    }
}
