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
  int lengthOfLIS(vector<int> &nums)
  {
    if (nums.size() <= 1)
      return nums.size();
    int result = 0;
    vector<int> dp(nums.size(), 1);
    for (int i = 1; i < nums.size(); i++)
    {
      for (int j = 0; j < i; j++)
      {
        if (nums[i] > nums[j])
          dp[i] = max(dp[i], dp[j] + 1);
      }
      if (dp[i] > result)
        result = dp[i];
    }
    return result;
  }
};