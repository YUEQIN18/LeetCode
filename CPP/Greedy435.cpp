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
    return a[1] < b[1]; // 按照右侧小到大排序
  }
  int eraseOverlapIntervals(vector<vector<int>> &intervals)
  {
    if (intervals.size() == 1)
      return 0;
    sort(intervals.begin(), intervals.end(), cmp);
    int result = 0;
    int end = intervals[0][1]; //右侧边界，越小越好 所以从左向右遍历
    for (int i = 1; i < intervals.size(); i++)
    {
      if (end > intervals[i][0])
      {
        result++; //遇到重叠
      }
      else
      {
        end = intervals[i][1];
      }
    }
    return result;
  }
};