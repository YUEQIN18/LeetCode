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
  int sumOfLeftLeaves(TreeNode *root)
  {
    if (root == NULL)
      return 0;

    int leftValue = sumOfLeftLeaves(root->left);   // 左
    int rightValue = sumOfLeftLeaves(root->right); // 右
                                                   // 中
    int midValue = 0;
    if (root->left && !root->left->left && !root->left->right)
    { // 中
      midValue = root->left->val;
    }
    int sum = midValue + leftValue + rightValue;
    return sum;
  }
};
// 迭代法
/*
class Solution
{
public:
  int sumOfLeftLeaves(TreeNode *root)
  {
    stack<TreeNode *> st;
    if (root == NULL)
      return 0;
    st.push(root);
    int result = 0;
    while (!st.empty())
    {
      TreeNode *node = st.top();
      st.pop();
      if (node->left != NULL && node->left->left == NULL && node->left->right == NULL)
      {
        result += node->left->val;
      }
      if (node->right)
        st.push(node->right);
      if (node->left)
        st.push(node->left);
    }
    return result;
  }
};