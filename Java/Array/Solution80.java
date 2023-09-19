package Array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int length = nums.length;
        for (int right = left; right < length; right++) {
            if (nums[right] == nums[left] && right - left >= 2) {
                remove(nums, right);
                length--;
            }
        }
        return length;
    }
    private void remove(int[] nums, int right) {

    }
}
