#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <unordered_set>
#include <map>
using namespace std;

class Solution
{
public:
  int maxProfit(vector<int> &prices)
  {
    int len = prices.size();
    if (len == 0)
      return 0;
    vector<vector<int>> dp(len, vector<int>(4, 0));
    //初始化
    dp[0][0] -= prices[0];
    for (int i = 1; i < len; i++)
    {
      //状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
      dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
      //状态二：卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
      dp[i][1] = max(dp[i - 1][1], dp[i - 1][3]);
      //状态三：今天卖出了股票
      dp[i][2] = dp[i - 1][0] + prices[i];
      //状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
      dp[i][3] = dp[i - 1][2];
    }
    return max(dp[len - 1][3], max(dp[len - 1][1], dp[len - 1][2]));
  }
};