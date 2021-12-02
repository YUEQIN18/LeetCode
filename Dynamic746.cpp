#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <map>
using namespace std;

class Solution
{
public:
  int minCostClimbingStairs(vector<int> &cost)
  {
    vector<int> dp(cost.size());
    dp[0] = cost[0];
    dp[1] = cost[1];
    for (int i = 2; i < cost.size(); i++)
    {
      dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
    }
    // 注意最后一步可以理解为不用花费，所以取倒数第一步，第二步的最少值
    return min(dp[cost.size() - 1], dp[cost.size() - 2]);
  }
};