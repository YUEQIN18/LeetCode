/*
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
class Solution238 {
    // 这道题不能用除法，又要求O(n)时间复杂度，所以应该用左前缀乘以右前缀，这其实是最难想到的。
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] l = new int[length];
        int[] r = new int[length];
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                l[i] = 1;
            } else {
                l[i] = l[i-1] * nums[i-1];
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                r[i] = 1;
            } else {
                r[i] = r[i+1] * nums[i+1];
            }
        }
        for (int i = 0; i < length; i++) {
            res[i] = l[i] * r[i];
        }
        return res;
    }
}