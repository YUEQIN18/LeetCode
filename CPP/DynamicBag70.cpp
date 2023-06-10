#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <map>
using namespace std;

class Solution
{
public:
  int climbStairs(int n)
  {
    vector<int> dp(n + 1, 0);
    dp[0] = 1;
    int m = 2; // 一次最多跨的台阶，本题为2
    for (int i = 1; i <= n; i++)
    { // 遍历背包
      for (int j = 1; j <= m; j++)
      { // 遍历物品
        if (i - j >= 0)
          dp[i] += dp[i - j];
      }
    }
    return dp[n];
  }
};