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
  int countSubstrings(string s)
  {
    if (s.size() <= 1)
      return s.size();
    vector<vector<bool>> dp(s.size(), vector<bool>(s.size(), false));
    int result = 0;
    for (int i = s.size() - 1; i >= 0; i--)
    {
      for (int j = i; j < s.size(); j++)
      {
        //情况一:下标i 与 j相同，同一个字符例如a，当然是回文子串
        //情况二：下标i 与 j相差为1，例如aa，也是文子串
        //情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，
        //那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]
        if (s[i] == s[j])
        {
          if (j - i <= 1)
          {
            dp[i][j] = true;
            result++;
          }
          else if (dp[i + 1][j - 1])
          {
            dp[i][j] = true;
            result++;
          }
        }
      }
    }
    return result;
  }
};