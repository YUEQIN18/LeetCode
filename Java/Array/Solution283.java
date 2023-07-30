package Array;

/*
 *  283. 移动零
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[slow] == 0 && nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow++] = temp;
            } else if (nums[slow] != 0 && nums[fast] != 0) {
                slow++;
            } else {
                continue;
            }
        }
    }
}
