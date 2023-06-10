#include <stddef.h>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Node
{
public:
  int val;
  Node *left;
  Node *right;
  Node *next;

  Node() : val(0), left(NULL), right(NULL), next(NULL) {}

  Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

  Node(int _val, Node *_left, Node *_right, Node *_next)
      : val(_val), left(_left), right(_right), next(_next) {}
};

class Solution
{
public:
  Node *connect(Node *root)
  {
    queue<Node *> que;
    if (root != NULL)
      que.push(root);

    while (!que.empty())
    {
      int size = que.size();
      vector<Node *> vec;
      // 这里一定要使用固定大小size，不要使用que.size()，因为que.size是不断变化的
      for (int i = 0; i < size; i++)
      {
        Node *node = que.front();
        que.pop();
        vec.push_back(node);
        if (node->left)
          que.push(node->left);
        if (node->right)
          que.push(node->right);
      }
      for (int i = 0; i < vec.size() - 1; i++)
      {
        vec[i]->next = vec[i + 1];
      }
    }
    return root;
  }
};