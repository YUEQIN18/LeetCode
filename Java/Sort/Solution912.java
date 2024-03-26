package Sort;

/**
 * @author qinyue
 * @create 2024-03-26 16:13:00
 * 912. 排序数组
 */
public class Solution912 {
    private static final Random RANDOM = new Random();
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right) return;
        // 因为快排面对相对有序的数组时会退化为O(n2) 所以先选取随机pivot
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);
        // [left + 1, lt] < pivot
        // [lt + 1, i) = pivot
        // [gt, right] > pivot
        int pivot = nums[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while (i < gt) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                gt--;
                swap(nums, i, gt);
            }
        }
        // 交换pivot和第二区间的第一个值，完成三个区间的划分
        swap(nums, left, lt);
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt, right);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
