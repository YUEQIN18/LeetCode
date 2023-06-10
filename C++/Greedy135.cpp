/*
这道题目一定是要确定一边之后，再确定另一边，例如比较每一个孩子的左边，然后再比较右边，如果两边一起考虑一定会顾此失彼。

先确定右边评分大于左边的情况（也就是从前向后遍历）
*/
#include <stddef.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <map>
using namespace std;

class Solution
{
public:
  int candy(vector<int> &ratings)
  {
    vector<int> candys(ratings.size(), 1);
    for (int i = 0; i < ratings.size() - 1; i++)
    {
      if (ratings[i + 1] > ratings[i])
        candys[i + 1] = candys[i] + 1;
    }
    for (int i = ratings.size() - 1; i > 0; i--)
    {
      if (ratings[i - 1] > ratings[i])
        candys[i - 1] = max(candys[i - 1], candys[i] + 1);
    }
    int sum = 0;
    for (int c : candys)
    {
      sum += c;
    }
    return sum;
  }
};