#include <stddef.h>
#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
  //next[] 是前缀表, j是 相同长度前缀后缀
  void getNext(int *next, const string &s)
  {
    int j = 0;
    next[0] = 0;
    for (int i = 1; i < s.size(); i++)
    {
      while (j > 0 && s[i] != s[j])
      {                  // j要保证大于0，因为下面有取j-1作为数组下标的操作
        j = next[j - 1]; // 注意这里，是要找前一位的对应的回退位置了
      }
      if (s[i] == s[j])
      { // 找到相同的前后缀
        j++;
      }
      next[i] = j; // 将j（前缀的长度）赋给next[i]
    }
  }
  int strStr(string haystack, string needle)
  {
    if (needle.size() == 0)
    {
      return 0;
    }
    int next[needle.size()];
    getNext(next, needle);
    int j = 0;
    for (int i = 0; i < haystack.size(); i++)
    { // 注意i就从0开始
      // 不匹配
      while (j > 0 && haystack[i] != needle[j])
      {
        j = next[j - 1]; // 找前一位的对应的回退位置
      }
      // 匹配，j和i同时向后移动, i的增加在循环里
      if (haystack[i] == needle[j])
      {
        j++;
      }
      // 文本串s里出现了模式串t
      if (j == needle.size())
      {
        return (i - needle.size() + 1);
      }
    }
    return -1;
  }
};