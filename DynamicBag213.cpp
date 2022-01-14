#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <unordered_set>
#include <map>
using namespace std;

class Solution
{
public:
  int rob(vector<int> &nums)
  {
    if (nums.size() == 0)
      return 0;
    if (nums.size() == 1)
      return nums[0];
    int result1 = robRange(nums, 0, nums.size() - 2); //不考虑尾元素
    int result2 = robRange(nums, 1, nums.size() - 1); //不考虑首元素
    return max(result1, result2);
  }
  int robRange(vector<int> &nums, int begin, int end)
  {
    if (begin == end)
      return nums[begin];
    vector<int> dp(nums.size());
    dp[begin] = nums[begin];
    dp[begin + 1] = max(nums[begin], nums[begin + 1]);
    for (int i = begin + 2; i <= end; i++)
    {
      dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[end];
  }
};