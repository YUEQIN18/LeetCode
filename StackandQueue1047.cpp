#include <stddef.h>
#include <iostream>
#include <stack>
using namespace std;
class Solution
{
public:
  string removeDuplicates(string s)
  {
    stack<char> st;
    for (char c : s)
    {
      if (st.empty() || c != st.top())
      {
        st.push(c);
      }
      else
      {
        st.pop(); // s 与 st.top()相等的情况
      }
    }
    string result;
    while (!st.empty())
    {
      result += st.top();
      st.pop();
    }
    reverse(result.begin(), result.end());
    return result;
  }
};