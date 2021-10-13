#include <stddef.h>
#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
  string reverseWords(string s)
  {
    removeExtraSpaces(s);        // 去掉冗余空格
    reverse(s, 0, s.size() - 1); // 将字符串全部反转
    for (int i = 0; i < s.size(); i++)
    {
      int j = i;
      // 查找单词间的空格，翻转单词
      while (j < s.size() && s[j] != ' ')
        j++;
      reverse(s, i, j - 1);
      i = j;
    }
    return s;
  }
  // 反转字符串s中左闭又闭的区间[start, end]
  void reverse(string &s, int start, int end)
  {
    for (int i = start, j = end; i < j; i++, j--)
    {
      swap(s[i], s[j]);
    }
  }
  // 移除冗余空格：使用双指针（快慢指针法）O(n)的算法
  void removeExtraSpaces(string &s)
  {
    int fast = 0, slow = 0;
    // 去掉字符串前面的空格
    while (s.size() > 0 && fast < s.size() && s[fast] == ' ')
      fast++;
    // 去掉字符串中间部分的冗余空格
    for (; fast < s.size(); fast++)
    {
      if (fast - 1 > 0 && s[fast] == s[fast - 1] && s[fast] == ' ')
        continue;
      else
        s[slow++] = s[fast];
    }
    // 去掉字符串末尾的空格
    if (slow - 1 > 0 && s[slow - 1] == ' ')
      s.resize(slow - 1);
    else
      s.resize(slow);
  }
};