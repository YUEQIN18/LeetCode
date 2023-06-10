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
private:
  // 在左闭右开区间[left, right)，构造二叉树
  TreeNode *traversal(vector<int> &nums, int left, int right)
  {
    // 遇到空节点
    if (left >= right)
      return nullptr;

    // 找到最大值：maxValueIndex
    int maxValueIndex = left;
    for (int i = left + 1; i < right; ++i)
    {
      if (nums[i] > nums[maxValueIndex])
        maxValueIndex = i;
    }
    // 根据最大值创建根节点
    TreeNode *root = new TreeNode(nums[maxValueIndex]);

    // 左闭右开：[left, maxValueIndex)
    root->left = traversal(nums, left, maxValueIndex);

    // 左闭右开：[maxValueIndex + 1, right)
    root->right = traversal(nums, maxValueIndex + 1, right);

    return root;
  }

public:
  TreeNode *constructMaximumBinaryTree(vector<int> &nums)
  {
    return traversal(nums, 0, nums.size());
  }
};