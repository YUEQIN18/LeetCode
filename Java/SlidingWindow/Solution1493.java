package SlidingWindow;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 */
public class Solution1493 {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int length = nums.length;
        int count = 0;
        int res = 0;
        int max = 0;
        while(right < length) {
            if (nums[right] == 0) {
                count++;
            } else {
                res++;
            }
            while (count > 1) {
                if (nums[left++] == 0) {
                    count--;
                } else {
                    res--;
                }
            }
            max = Math.max(max, res);
            right++;
        }
        return count == 0 ? max - 1 : max;
    }
}
