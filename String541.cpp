#include <stddef.h>
#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
  void reverse(string &s, int start, int end)
  {
    for (int i = start, j = end; i < j; i++, j--)
    {
      swap(s[i], s[j]);
    }
  }
  string reverseStr(string s, int k)
  {
    for (int i = 0; i < s.size(); i += (2 * k))
    {
      // 1. 每隔 2k 个字符的前 k 个字符进行反转
      // 2. 剩余字符小于 2k 但大于或等于 k 个，则只反转前 k 个字符
      // (i + k) <= s.size()说明s的长度足够一个2k+k，只有有足够长度
      // 才会对k个进行翻转，这道题描述太烂了
      if (i + k <= s.size())
      {
        reverse(s, i, i + k - 1);
        continue;
      }
      // 3. 剩余字符少于 k 个，则将剩余字符全部反转。
      reverse(s, i, s.size() - 1);
    }
    return s;
  }
};