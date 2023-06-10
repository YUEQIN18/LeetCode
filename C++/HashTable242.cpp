#include <stddef.h>
#include <iostream>
using namespace std;

class Solution
{
public:
  bool isAnagram(string s, string t)
  {
    int record[26] = {0};
    // 遍历string s
    for (int i = 0; i < s.size(); i++)
    {
      record[s[i] - 'a']++;
    }
    // 遍历string t
    for (int j = 0; j < t.size(); j++)
    {
      record[t[j] - 'a']--;
    }
    // 检查record所有元素是否为0
    for (int k = 0; k < 26; k++)
    {
      if (record[k] != 0)
        return false;
    }
    return true;
  }
};
