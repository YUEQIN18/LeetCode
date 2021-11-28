#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <map>
using namespace std;

//所以我们在做收获利润操作的时候其实有三种情况：

//情况一：收获利润的这一天并不是收获利润区间里的最后一天（不是真正的卖出，相当于持有股票），所以后面要继续收获利润。
//情况二：前一天是收获利润区间里的最后一天（相当于真正的卖出了），今天要重新记录最小价格了。
//情况三：不作操作，保持原有状态（买入，卖出，不买不卖）
class Solution
{
public:
  int maxProfit(vector<int> &prices, int fee)
  {
    int result = 0;
    int minPrice = prices[0]; // 记录最低价格
    for (int i = 1; i < prices.size(); i++)
    {
      // 情况二：相当于买入
      if (prices[i] < minPrice)
        minPrice = prices[i];

      // 情况三：保持原有状态（因为此时买则不便宜，卖则亏本）
      if (prices[i] >= minPrice && prices[i] <= minPrice + fee)
      {
        continue;
      }

      // 计算利润，可能有多次计算利润，最后一次计算利润才是真正意义的卖出
      if (prices[i] > minPrice + fee)
      {
        result += prices[i] - minPrice - fee;
        minPrice = prices[i] - fee; // 情况一，这一步很关键
      }
    }
    return result;
  }
};