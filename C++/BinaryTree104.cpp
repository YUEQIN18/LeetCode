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
  int getdepth(TreeNode *node)
  {
    if (node == NULL)
      return 0;
    int leftdepth = getdepth(node->left);       // 左
    int rightdepth = getdepth(node->right);     // 右
    int depth = 1 + max(leftdepth, rightdepth); // 中
    return depth;
  }
  int maxDepth(TreeNode *root)
  {
    return getdepth(root);
  }
};