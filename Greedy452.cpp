#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <map>
using namespace std;

class Solution
{
public:
  static bool cmp(vector<int> &a, vector<int> &b)
  {
    return a[1] < b[1]; // 按照气球右侧小到大排序
  }
  int findMinArrowShots(vector<vector<int>> &points)
  {
    if (points.size() == 0)
      return 0;
    sort(points.begin(), points.end(), cmp);
    int result = 1;
    int arrowPos = points[0][1]; //箭的位置应该尽可能靠右
    for (int i = 1; i < points.size(); i++)
    {
      if (arrowPos >= points[i][0]) //重叠了，跳过
        continue;
      result++; // 没有重叠，需要额外的箭
      arrowPos = points[i][1]; 
    }
    return result;
  }
};