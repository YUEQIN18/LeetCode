// Hello Leetcode
/*
我们定义 target 是在一个在左闭右闭的区间里，也就是[left, right].
然后定义left = 0,
mid = (left + right) / 2, right = nums.size() - 1
搞清楚区间的问题，二分法就会很简单
*/
#include <vector>
using namespace std;
class Solution
{
public:
  int search(vector<int> &nums, int target)
  {
    int left = 0;
    int right = nums.size() - 1;
    while (left <= right)
    {
      int mid = (left + right) / 2;
      if (nums[mid] < target)
      {
        left = mid + 1;
      }
      else if (nums[mid] > target)
      {
        right = mid - 1;
      }
      else
        return mid;
    }
    return -1;
  }
};
