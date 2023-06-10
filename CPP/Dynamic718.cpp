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
  int findLength(vector<int> &nums1, vector<int> &nums2)
  {
    //dp[0][0] 是没意义的数，所以dp数组的行列都需要+1
    vector<vector<int>> dp(nums1.size() + 1, vector<int>(nums2.size() + 1, 0));
    int result = 0;
    for (int i = 1; i <= nums1.size(); i++)
    {
      for (int j = 1; j <= nums2.size(); j++)
      {
        if (nums2[j - 1] == nums1[i - 1])
          dp[i][j] = dp[i - 1][j - 1] + 1;
        if (dp[i][j] > result)
          result = dp[i][j];
      }
    }
    return result;
  }
};