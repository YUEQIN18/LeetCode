package Array;

class Solution704 {
    // 这道题看起来简单，但要想清楚是用开区间还是闭区间，这里是用的后者，[left, right]
    public int search(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            mid = left + ((right - left) / 2);
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }       
        return -1;
    }
}