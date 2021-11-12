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
    if (target < 0)
      return;
    for (int i = startIndex; i < candidates.size(); i++)
    {
      path.push_back(candidates[i]);
      // 不用i+1了，表示可以重复读取当前的数
      backtracking(candidates, target - candidates[i], i);
      path.pop_back();
    }
  }
  vector<vector<int>> combinationSum(vector<int> &candidates, int target)
  {
    if (candidates.size() == 0)
      return result;
    backtracking(candidates, target, 0);
    return result;
  }
};