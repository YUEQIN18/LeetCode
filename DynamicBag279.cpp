#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <map>
using namespace std;

class Solution
{
public:
  int numSquares(int n)
  {
    vector<int> dp(n + 1, INT_MAX);
    dp[0] = 0;
    for (int i = 1; i * i <= n; i++)
    { // 遍历物品
      for (int j = 1; j <= n; j++)
      { // 遍历背包
        if (j - i * i >= 0)
        {
          dp[j] = min(dp[j - i * i] + 1, dp[j]);
        }
      }
    }
    return dp[n];
  }
};