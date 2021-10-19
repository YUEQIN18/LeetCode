#include <stddef.h>
#include <iostream>
#include <queue>
using namespace std;
class MyStack
{
public:
  queue<int> que;
  MyStack()
  {
  }

  void push(int x)
  {
    que.push(x);
  }

  int pop()
  {
    int size = que.size();
    size--;
    while (size--)
    {
      // 将队列头部的元素（除了最后一个元素外） 重新添加到队列尾部
      que.push(que.front());
      que.pop();
    }
    int result = que.front();
    que.pop();
    return result;
  }

  int top()
  {
    return que.back();
  }

  bool empty()
  {
    return que.empty();
  }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */