#include <stddef.h>
#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution
{
public:
  // 给一个两位数n ，n的十位是n%10， n的个位需要n/10之后再计算
  int getSum(int n)
  {
    int sum = 0;
    while (n)
    {
      sum += (n % 10) * (n % 10);
      n /= 10;
    }
    return sum;
  }
  bool isHappy(int n)
  {
    unordered_set<int> set;
    // 一直循环，如果发现sum已经在set里，说明进入了无限循环，应该false
    while (1)
    {
      int sum = getSum(n);
      if (sum == 1)
        return true;
      if (set.find(sum) != set.end())
        return false;
      else
        set.insert(sum);
      n = sum;
    }
  }
};