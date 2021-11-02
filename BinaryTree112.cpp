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

class solution
{
private:
  bool traversal(treenode *cur, int count)
  {
    if (!cur->left && !cur->right && count == 0)
      return true; // 遇到叶子节点，并且计数为0
    if (!cur->left && !cur->right)
      return false; // 遇到叶子节点直接返回

    if (cur->left)
    {                          // 左
      count -= cur->left->val; // 递归，处理节点;
      if (traversal(cur->left, count))
        return true;
      count += cur->left->val; // 回溯，撤销处理结果
    }
    if (cur->right)
    {                           // 右
      count -= cur->right->val; // 递归，处理节点;
      if (traversal(cur->right, count))
        return true;
      count += cur->right->val; // 回溯，撤销处理结果
    }
    return false;
  }

public:
  bool haspathsum(treenode *root, int sum)
  {
    if (root == null)
      return false;
    return traversal(root, sum - root->val);
  }
};