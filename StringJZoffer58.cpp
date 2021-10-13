#include <stddef.h>
#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
  string reverseLeftWords(string s, int n)
  {
    //先反转前面n个字符
    reverse(s.begin(), s.begin() + n);
    //再反转后面n到末尾个字符
    reverse(s.begin() + n, s.end());
    //最后全部反转
    //先局部，后全部 和 先全部，后局部 是一样的
    reverse(s.begin(), s.end());
    return s;
  }
};