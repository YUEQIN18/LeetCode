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
  int getDepth(TreeNode *node)
  {
    if (node == NULL)
      return 0;
    int leftDepth = getDepth(node->left);
    if (leftDepth == -1)
      return -1;
    int rightDepth = getDepth(node->right);
    if (rightDepth == -1)
      return -1;
    return abs(leftDepth - rightDepth) > 1 ? -1 : max(leftDepth, rightDepth) + 1;
  }
  bool isBalanced(TreeNode *root)
  {
    return getDepth(root) == -1 ? false : true;
  }
};