package SlidingWindow;

/*
643. 子数组最大平均数 I
给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。

请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。

任何误差小于 10-5 的答案都将被视为正确答案。
 */
public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        // 先对前k个元素求和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        // 滑动窗口 sum等于减去之前第一个元素(i-k)，再加上第i个元素
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
