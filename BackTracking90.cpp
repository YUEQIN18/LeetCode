#include <stddef.h>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution
{
private:
  vector<vector<int>> result;
  vector<int> path;
  void backtracking(vector<int> &nums, int startIndex)
  {
    result.push_back(path);
    for (int i = startIndex; i < nums.size(); i++)
    {
      // 而我们要对同一树层使用过的元素进行跳过
      if (i > startIndex && nums[i] == nums[i - 1])
      { // 注意这里使用i > startIndex
        continue;
      }
      path.push_back(nums[i]);
      backtracking(nums, i + 1);
      path.pop_back();
    }
  }

public:
  vector<vector<int>> subsetsWithDup(vector<int> &nums)
  {
    result.clear();
    path.clear();
    sort(nums.begin(), nums.end()); // 去重需要排序
    backtracking(nums, 0);
    return result;
  }
};