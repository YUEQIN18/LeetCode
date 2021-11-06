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
  TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
  {
    if (root == nullptr)
      return root;
    if (root->val > p->val && root->val > q->val)
    {
      TreeNode *left = lowestCommonAncestor(root->left, p, q);
      if (left != nullptr)
        return left;
    }
    if (root->val < p->val && root->val < q->val)
    {
      TreeNode *right = lowestCommonAncestor(root->right, p, q);
      if (right != nullptr)
        return right;
    }
    // 从上到下遍历的时候，cur节点是数值在[p, q]区间中则说明该节点cur就是最近公共祖先
    return root;
  }
};