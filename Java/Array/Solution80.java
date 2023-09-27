package Array;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution80 {
    // 双指针法，直接由fast和slow指针遍历一次数组，slow即为最终的长度
    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        if (length <= 2) return length;
        int slow = 2, fast = 2;
        while(fast < length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    // 我最初的做法，就叫做遍历删除法吧！
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int length = nums.length;
        for (int right = left; right < length; right++) {
            if (nums[right] == nums[left]) {
                if (right - left >= 2) {
                    remove(nums, right);
                    length--;
                    right--;
                }
            } else {
                left = right;
            }
        }
        return length;
    }
    private void remove(int[] nums, int right) {
        int p1 = right, p2 = right + 1;
        while (p2 < nums.length) {
            nums[p1++] = nums[p2++];
        }
    }

    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        int[] nums = new int[] {0,0,1,1,1,1,2,3,3};
        int i = solution80.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
