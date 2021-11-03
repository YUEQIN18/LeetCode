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
  vector<vector<int>> result;
  vector<int> path;
  void traversal(TreeNode *cur, int count)
  {
    if (!cur->left && !cur->right && count == 0)
    { // 遇到了叶子节点且找到了和为sum的路径
      result.push_back(path);
      return;
    }
    if (!cur->left && !cur->right)
      return; // 遇到叶子节点而没有找到合适的边，直接返回
    if (cur->left)
    { // 左 （空节点不遍历）
      path.push_back(cur->left->val);
      count -= cur->left->val;
      traversal(cur->left, count); // 递归
      count += cur->left->val;     // 回溯
      path.pop_back();             // 回溯
    }
    if (cur->right)
    { // 右 （空节点不遍历）
      path.push_back(cur->right->val);
      count -= cur->right->val;
      traversal(cur->right, count); // 递归
      count += cur->right->val;     // 回溯
      path.pop_back();              // 回溯
    }
    return;
  }

  vector<vector<int>> pathSum(TreeNode *root, int targetSum)
  {
    if (root == nullptr)
      return result;
    path.push_back(root->val); // 把根节点放进路径
    traversal(root, targetSum - root->val);
    return result;
  }
};