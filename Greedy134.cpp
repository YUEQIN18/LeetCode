#include <stddef.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <map>
using namespace std;

/*
那么为什么一旦[i，j] 区间和为负数，起始位置就可以是j+1呢，j+1后面就不会出现更大的负数？

如果出现更大的负数，就是更新j，那么起始位置又变成新的j+1了。

而且j之前出现了多少负数，j后面就会出现多少正数，因为耗油总和是大于零的（前提我们已经确定了一定可以跑完全程）。

那么局部最优：当前累加rest[j]的和curSum一旦小于0，起始位置至少要是j+1，因为从j开始一定不行。全局最优：找到可以跑一圈的起始位置。
*/
class Solution
{
public:
  int canCompleteCircuit(vector<int> &gas, vector<int> &cost)
  {
    int start = 0;
    int curSum = 0;
    int sum = 0;
    for (int i = 0; i < gas.size(); i++)
    {
      curSum += gas[i] - cost[i];
      sum += gas[i] - cost[i];
      if (curSum < 0)
      {
        start = i + 1;
        curSum = 0;
      }
    }
    if (sum < 0)
      return -1;
    return start;
  }
};