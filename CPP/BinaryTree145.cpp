#include <stddef.h>
#include <iostream>
#include <vector>
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
  void traversal(TreeNode *cur, vector<int> &result)
  {
    if (cur == NULL)
      return;
    traversal(cur->left, result);
    traversal(cur->right, result);
    result.push_back(cur->val);
  }
  vector<int> postorderTraversal(TreeNode *root)
  {
    vector<int> result;
    traversal(root, result);
    return result;
  }
};