package SlidingWindow;
/*
1004. 最大连续1的个数 III
给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int res = 0;
        int left = 0, right = 0;
        int count = 0;
        while (right < length) {
            if (nums[right] == 0) {
                count++;
            }
            // 如果滑动窗口内的0个数 > k 了，不断右移left直至count < 0
            while (count > k) {
                if(nums[left++] == 0) {
                    count--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
