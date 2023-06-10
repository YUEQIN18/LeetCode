#include <stddef.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <map>
using namespace std;

class Solution
{
public:
  // 比较函数，绝对值从大到小排序
  static bool cmp(int a, int b)
  {
    return abs(a) > abs(b);
  }
  int largestSumAfterKNegations(vector<int> &nums, int k)
  {
    int sum = 0;
    sort(nums.begin(), nums.end(), cmp);
    //尽可能把数组变成正数
    for (int i = 0; i < nums.size(); i++)
    {
      if (k > 0 && nums[i] < 0)
      {
        nums[i] = -nums[i];
        k--;
      }
    }
    //如果k有剩余，且为奇数，就变换最小的数
    if (k % 2 == 1)
    {
      nums[nums.size() - 1] *= -1;
    }
    for (int i = 0; i < nums.size(); i++)
    {
      sum += nums[i];
    }
    return sum;
  }
};