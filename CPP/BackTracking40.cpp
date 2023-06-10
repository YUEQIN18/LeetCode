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
  void backtracking(vector<int> &candidates, int target, int startIndex)
  {
    if (target == 0)
    {
      result.push_back(path);
      return;
    }
    for (int i = startIndex; i < candidates.size() && candidates[i] <= target; i++)
    {
      // 要对同一树层使用过的元素进行跳过
      if (i > startIndex && candidates[i] == candidates[i - 1])
        continue;
      path.push_back(candidates[i]);
      // 和39.组合总和的区别1，这里是i+1，每个数字在每个组合中只能使用一次
      backtracking(candidates, target - candidates[i], i + 1);
      path.pop_back();
    }
  }
  vector<vector<int>> combinationSum2(vector<int> &candidates, int target)
  {
    // 首先把给candidates排序，让其相同的元素都挨在一起。
    sort(candidates.begin(), candidates.end());
    backtracking(candidates, target, 0);
    return result;
  }
};