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
  int findLengthOfLCIS(vector<int> &nums)
  {
    int result = 1;
    int len = nums.size();
    if (len <= 1)
      return len;
    vector<int> dp(len, 1);
    for (int i = 1; i < len; i++)
    {
      if (nums[i] > nums[i - 1])
        dp[i] = dp[i - 1] + 1;
      if (dp[i] > result)
        result = dp[i];
    }
    return result;
  }
};