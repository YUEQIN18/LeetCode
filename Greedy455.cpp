#include <stddef.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <map>
using namespace std;

// 时间复杂度：O(nlogn)
// 空间复杂度：O(1)
class Solution
{
public:
  int findContentChildren(vector<int> &g, vector<int> &s)
  {
    sort(g.begin(), g.end());
    sort(s.begin(), s.end());
    int index = s.size() - 1; // 饼干数组的下表
    int result = 0;
    for (int i = g.size() - 1; i >= 0; i--)
    {
      if (index >= 0 && s[index] >= g[i])
      {
        result++;
        index--;
      }
    }
    return result;
  }
};