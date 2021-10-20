#include <stddef.h>
#include <iostream>
#include <stack>
using namespace std;
class Solution
{
public:
  bool isValid(string s)
  {
    stack<int> st;
    for (int i = 0; i < s.size(); i++)
    {
      if (s[i] == '(')
        st.push(')');
      else if (s[i] == '[')
        st.push(']');
      else if (s[i] == '{')
        st.push('}');
      // 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号
      else if (st.empty())
        return false;
      // 第二种情况：遍历字符串匹配的过程中，发现栈里没有我们要匹配的字符。所以return false
      else if (st.top() != s[i])
        return false;
      else
        st.pop(); // st.top() 与 s[i]相等，栈弹出元素
    }
    // 第一种情况：此时我们已经遍历完了字符串，如果栈为空，则true，若不为空，说明有相应的左括号没有右括号来匹配
    return st.empty();
  }
};