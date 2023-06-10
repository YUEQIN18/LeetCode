#include <stddef.h>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution
{
public:
  vector<vector<int>> result;
  vector<int> path;
  void backtracking(vector<int> &nums, int startIndex)
  {
    // 没有终止条件，因为要遍历整个树
    result.push_back(path);

    for (int i = startIndex; i < nums.size(); i++)
    {
      path.push_back(nums[i]);
      backtracking(nums, i + 1);
      path.pop_back();
    }
  }
  vector<vector<int>> subsets(vector<int> &nums)
  {
    if (nums.size() == 0)
      return result;
    backtracking(nums, 0);
    return result;
  }
};