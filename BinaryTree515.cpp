#include <stddef.h>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct TreeNode
{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
class Solution
{
public:
  vector<int> largestValues(TreeNode *root)
  {
    queue<TreeNode *> que;
    if (root != NULL)
      que.push(root);
    vector<int> result;
    while (!que.empty())
    {
      int size = que.size();
      vector<int> vec;
      for (int i = 0; i < size; i++)
      {
        TreeNode *node = que.front();
        que.pop();
        vec.push_back(node->val);
        if (node->left)
          que.push(node->left);
        if (node->right)
          que.push(node->right);
      }
      int max = INT_MIN;
      for (auto v : vec)
      {
        if (v > max)
          max = v;
      }
      result.push_back(max);
    }
    return result;
  }
};