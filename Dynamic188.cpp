class Solution
{
public:
  int maxProfit(int k, vector<int> &prices)
  {
    int len = prices.size();
    if (len == 0)
      return 0;
    vector<vector<int>> dp(len, vector<int>(2 * k + 1, 0));
    for (int j = 1; j < 2 * k + 1; j += 2)
    {
      dp[0][j] = -prices[0];
    }
    for (int i = 1; i < len; i++)
    {
      for (int j = 0; j < 2 * k - 1; j += 2)
      {
        dp[i][j + 1] = max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
        dp[i][j + 2] = max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
      }
    }
    return dp[len - 1][2 * k];
  }
};