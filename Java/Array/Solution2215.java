package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<Integer> n1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> n2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<List<Integer>> res = new ArrayList<>();
        for (int j : nums1) {
            if (!n2.contains(j) && !ans1.contains(j)) ans1.add(j);
        }
        for (int j : nums2) {
            if (!n1.contains(j) && !ans2.contains(j)) ans2.add(j);
        }
        res.add(ans1);
        res.add(ans2);
        return res;
    }
}
