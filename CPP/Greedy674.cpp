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
  int findLengthOfLCIS(vector<int> &nums)
  {
    if (nums.size() == 0)
      return 0;
    int len = nums.size();
    int count = 1;
    int result = 1;
    for (int i = 1; i < len; i++)
    {
      if (nums[i] > nums[i - 1])
        count++;
      else
      {
        count = 1;
      }
      if (count > result)
        result = count;
    }
    return result;
  }
};