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
  int countNodes(TreeNode *root)
  {
    if (root == nullptr)
      return 0;
    int leftHeight = 0;
    int rightHeight = 0;
    TreeNode *left = root->left;
    TreeNode *right = root->right;
    while (left)
    {
      leftHeight++;
      left = left->left;
    }
    while (right)
    {
      rightHeight++;
      right = right->right;
    }
    if (leftHeight == rightHeight)
      return (2 << leftHeight) - 1; // 注意(2 << 1) 相当于2^2，所以leftHeight初始为0
    return countNodes(root->left) + countNodes(root->right) + 1;
  }
};