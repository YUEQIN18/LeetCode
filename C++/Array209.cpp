#include <vector>
using namespace std;

class Solution
{
public:
  int minSubArrayLen(int target, vector<int> &nums)
  {
    int result = INT32_MAX;
    int sum = 0;       // 滑动窗口数值之和
    int i = 0;         // 滑动窗口起始位置
    int subLength = 0; // 滑动窗口的长度
    for (int j = 0; j < nums.size(); j++)
    {
      sum += nums[j];
      while (sum >= target)
      {
        subLength = j - i + 1;
        result = result < subLength ? result : subLength;
        sum -= nums[i];
        i++; //这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
      }
    }
    return result == INT32_MAX ? 0 : result;
  }
};