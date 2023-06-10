#include <stddef.h>
#include <iostream>
#include <stack>
using namespace std;
class MyQueue
{
public:
  stack<int> in;
  stack<int> out;

  MyQueue()
  {
  }

  void push(int x)
  {
    in.push(x);
  }

  int pop()
  {
    // 只有当stOut为空的时候，再从stIn里导入数据（导入stIn全部数据
    if (out.empty())
    {
      while (!in.empty())
      {
        // 从stIn导入数据直到stIn为空
        out.push(in.top());
        in.pop();
      }
    }
    int result = out.top();
    out.pop();
    return result;
  }

  int peek()
  {
    int res = this->pop();
    out.push(res);
    return res;
  }

  bool empty()
  {
    return in.empty() && out.empty();
  }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */