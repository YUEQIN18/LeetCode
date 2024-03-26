package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author qinyue
 * @create 2024-03-26 16:21:00
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Solution215 {
    private static final Random RANDOM = new Random();
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums[len - k];
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

    // 堆排序法（优先级队列）
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        // 使用一个长度为k的最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        // 逐个插入堆
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        // 从k个元素开始 比堆顶元素大就入堆，这样堆中就保持了前k个大元素
        for (int i = k; i < len; i++) {
            int top = heap.peek();
            if (nums[i] > top) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }
}
