package Array;

import java.util.Arrays;

/*
1679. K 和数对的最大数目
给你一个整数数组 nums 和一个整数 k 。

每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。

返回你可以对数组执行的最大操作数。
 */
public class Solution1679 {

    public int maxOperations(int[] nums, int k) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int count = 0;
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int res = nums[l] + nums[r];
            if (res == k) {
                count++;
                l++;
                r--;
            } else if (res > k) {
                r--;
            } else {
                l++;
            }
        }
        return count;
    }
}
