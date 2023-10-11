package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class Solution15 {
    // 这道题用暴力枚举的话是O(n3)，而且去重会很困难，我一开始想到了要用双指针，而大部分使用双指针的情况其实都是排序之后的
    // 所以这道题的思路就比较清晰了。
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 如果第一个数就大于0，后面的肯定也大于0了
            if (nums[i] > 0) break;
            // 去重
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = length - 1;
            int target = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Stream.of(nums[i], nums[l], nums[r]).collect(Collectors.toList()));
                    // 去重
                    while(l < r && nums[l+1] == nums[l]) l++;
                    while(l < r && nums[r-1] == nums[r]) r--;
                    // 加入结果集之后应该同时移动左右指针，因为数组已经排序了，只移动一个会导致过大或者过小，只有同时移动才能重新和target相等
                    // 同时移动左右指针，这里是真正的移动，上面的只是去重
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target){
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
