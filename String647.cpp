#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <unordered_set>
#include <map>
using namespace std;

// 双指针法
class Solution
{
public:
  int countSubstrings(string s)
  {
    int res = 0;
    for (int i = 0; i < s.size(); i++)
    {
      res += extend(s, i, i, s.size());
      res += extend(s, i, i + 1, s.size());
    }
    return res;
  }
  int extend(string s, int i, int j, int n)
  {
    int res = 0;
    while (i >= 0 && j < n && s[i] == s[j])
    {
      i--;
      j++;
      res++;
    }
    return res;
  }
};