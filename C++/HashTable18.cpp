#include <stddef.h>
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;
class Solution
{
public:
  vector<vector<int>> fourSum(vector<int> &nums, int target)
  {
    vector<vector<int> > result;
    sort(nums.begin(), nums.end());
    for (int k = 0; k < nums.size(); k++)
    {
      // 去重
      if (k > 0 && nums[k] == nums[k - 1])
      {
        continue;
      }
      for (int i = k + 1; i < nums.size(); i++)
      {
        // 正确去重方法
        if (i > k + 1 && nums[i] == nums[i - 1])
        {
          continue;
        }
        int left = i + 1;
        int right = nums.size() - 1;
        while (left < right)
        {
          int s = nums[k] + nums[i] + nums[left] + nums[right];
          if (s > target)
          {
            right--;
          }
          else if (s < target)
          {
            left++;
          }
          else
          {
            result.push_back(vector<int>{nums[k], nums[i], nums[left], nums[right]});
            // 去重逻辑应该放在找到一个四元组之后
            while (right > left && nums[right] == nums[right - 1])
              right--;
            while (right > left && nums[left] == nums[left + 1])
              left++;
            // 找到答案时，双指针同时收缩
            right--;
            left++;
          }
        }
      }
    }
    return result;
  }
};

