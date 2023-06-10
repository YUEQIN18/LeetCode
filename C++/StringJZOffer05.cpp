#include <stddef.h>
#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
  string replaceSpace(string s)
  {
    int count = 0; // 统计空格的个数
    int oldSize = s.size();
    for (int i = 0; i < s.size(); i++)
    {
      if (s[i] == ' ')
      {
        count++;
      }
    }
    // 扩充字符串s的大小，也就是每个空格替换成"%20"之后的大小
    s.resize(s.size() + count * 2);
    int newSize = s.size();
    for (int i = oldSize - 1, j = newSize - 1; i < j; i--, j--)
    {
      if (s[i] != ' ')
      {
        s[j] = s[i];
      }
      else
      {
        s[j] = '0';
        s[j - 1] = '2';
        s[j - 2] = '%';
        j -= 2;
      }
    }
    return s;
  }
};