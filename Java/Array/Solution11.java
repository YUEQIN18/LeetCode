package Array;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class Solution11 {
    // 这道题一开是想得是用 贪心，可惜我没想到除了两层For循环之外得算法
    // 没想到直接用双指针就可以了，这里我们在移动指针的时候，只移动高度小的那个指针
    // 因为移动高度高的那个指针会导致面积不变或者变小，所以移动矮的那个指针。
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int size = 0;
        while (l < r) {
            size = Math.max(size, (r -l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return size;
    }
}
