/*
 * 334. 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 */
public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if(length < 3) return false;
        int first = nums[0]; // 把首个数赋值给first
        int second = Integer.MAX_VALUE;
        // 从index=1开始
        for(int i = 1; i < length; i++) {
            if(nums[i] > second) {
                return true;
            }else if(nums[i] > first) {
                second = nums[i];
            }else {
                first = nums[i];
            }
        }
        return false;
    }
}
