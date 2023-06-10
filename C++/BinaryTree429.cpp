#include <stddef.h>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Node
{
public:
  int val;
  vector<Node *> children;

  Node() {}

  Node(int _val)
  {
    val = _val;
  }

  Node(int _val, vector<Node *> _children)
  {
    val = _val;
    children = _children;
  }
};

class Solution
{
public:
  vector<vector<int> > levelOrder(Node *root)
  {
    queue<Node *> que;
    if (root != NULL)
      que.push(root);
    vector<vector<int> > result;
    while (!que.empty())
    {
      int size = que.size();
      vector<int> vec;
      // 这里一定要使用固定大小size，不要使用que.size()，因为que.size是不断变化的
      for (int i = 0; i < size; i++)
      {
        Node *node = que.front();
        que.pop();
        vec.push_back(node->val);
        if (!node->children.empty())
        {
          for (auto n : node->children)
          {
            que.push(n);
          }
        }
      }
      result.push_back(vec);
    }
    return result;
  }
};