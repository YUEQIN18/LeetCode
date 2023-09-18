package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 最长字串：连续的
 * 最长子序列：可以不连续
 */
public class Solution3 {
    // 这道题如果能想到用滑动窗口就差不多做出来了
    // 和常规的滑动窗口不同，我们没有双重循环去左移窗口（并且删除map里的数据），
    // 而是将左窗口left跳到出现重复的字符索引+1或者不跳
    // 第一种情况：左窗口跳跃，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
    //             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
    // 第二种情况，不跳跃，如：如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
    //             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2；
    //             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
    //             应该不变，left始终为2，子段变成 ba才对。
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(c, right);
            res = Math.max(res, right - left + 1);

        }
        return res;
    }
}
