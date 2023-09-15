package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Solution189 {
    // 除了额外数组法，还有一种方法：数组翻转，先翻转全部，再分别翻转[0, k % n) 和 [k % n, n)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }


    public static void main(String[] args) {
        Solution189 solution189 = new Solution189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution189.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
