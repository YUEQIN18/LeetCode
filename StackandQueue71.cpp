#include <stddef.h>
#include <iostream>
#include <stack>
using namespace std;
class Solution
{
public:
  string simplifyPath(string path)
  {
    stack<string> s;
    int start = 1;
    for (int i = 1; i <= path.length(); ++i)
    {
      if (i == path.length() || path[i] == '/')
      {
        string p = path.substr(start, i - start);
        if (p == "/")
          continue;
        if (p == "..")
        {
          if (!s.empty())
            s.pop();
        }
        else if (p.length() > 0 && p != ".")
        {
          s.push(p);
        }
        start = i + 1;
      }
    }

    string result;
    while (!s.empty())
    {
      result = '/' + s.top() + result;
      s.pop();
    }
    return result.empty() ? "/" : result;
  }
};