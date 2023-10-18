package HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;    // 记录最长连续序列的长度
        Set<Integer> numSet = new HashSet<>();  // 记录所有的数值
        for(int num: nums){
            numSet.add(num);    // 将数组中的值加入哈希表中
        }
        int seqLen;     // 连续序列的长度
        for(int num: numSet){
            // 如果当前的数是一个连续序列的起点，统计这个连续序列的长度
            if(!numSet.contains(num - 1)){
                seqLen = 1;
                while(numSet.contains(++num))seqLen++;  // 不断查找连续序列，直到num的下一个数不存在于数组中
                res = Math.max(res, seqLen);    // 更新最长连续序列长度
            }
        }
        return res;
    }
}
