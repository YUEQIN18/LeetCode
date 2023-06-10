#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <map>
using namespace std;

// 先遍历物品，在遍历背包
// 和先遍历背包再遍历物品是一样的
void test_CompletePack()
{
  vector<int> weight = {1, 3, 4};
  vector<int> value = {15, 20, 30};
  int bagWeight = 4;
  vector<int> dp(bagWeight + 1, 0);
  for (int i = 0; i < weight.size(); i++)
  { // 遍历物品
    for (int j = weight[i]; j <= bagWeight; j++)
    { // 遍历背包容量
      dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
    }
  }
  cout << dp[bagWeight] << endl;
}
int main()
{
  test_CompletePack();
}