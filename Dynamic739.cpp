#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <unordered_set>
#include <map>
#include <stack>
using namespace std;

class Solution
{
public:
  vector<int> dailyTemperatures(vector<int> &T)
  {
    // 递增栈
    stack<int> st;
    vector<int> result(T.size(), 0);
    st.push(0);
    for (int i = 1; i < T.size(); i++)
    {
      if (T[i] < T[st.top()])
      { // 情况一
        st.push(i);
      }
      else if (T[i] == T[st.top()])
      { // 情况二
        st.push(i);
      }
      else
      {
        while (!st.empty() && T[i] > T[st.top()])
        { // 情况三
          result[st.top()] = i - st.top();
          st.pop();
        }
        st.push(i);
      }
    }
    return result;
  }
};