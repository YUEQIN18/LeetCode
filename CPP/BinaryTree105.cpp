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
  TreeNode *traversal(vector<int> &preorder, vector<int> &inorder)
  {
    if (preorder.size() == 0)
      return NULL;

    // 前序遍历数组第一个元素，就是当前的中间节点
    int rootValue = preorder[0];
    TreeNode *root = new TreeNode(rootValue);

    // 叶子节点
    if (preorder.size() == 1)
      return root;

    // 找到中序遍历的切割点
    int delimiterIndex;
    for (delimiterIndex = 0; delimiterIndex < inorder.size(); delimiterIndex++)
    {
      if (inorder[delimiterIndex] == rootValue)
        break;
    }

    // 切割中序数组
    // 左闭右开区间：[0, delimiterIndex)
    vector<int> leftInorder(inorder.begin(), inorder.begin() + delimiterIndex);
    // [delimiterIndex + 1, end)
    vector<int> rightInorder(inorder.begin() + delimiterIndex + 1, inorder.end());

    // preorder 舍弃首元素
    preorder.erase(preorder.begin());

    // 切割前序数组
    // 依然左闭右开，注意这里使用了左中序数组大小作为切割点
    // [0, leftInorder.size)
    vector<int> leftPreorder(preorder.begin(), preorder.begin() + leftInorder.size());
    // [leftInorder.size(), end)
    vector<int> rightPreorder(preorder.begin() + leftInorder.size(), preorder.end());

    root->left = traversal(leftPreorder, leftInorder);
    root->right = traversal(rightPreorder, rightInorder);

    return root;
  }

public:
  TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
  {
    if (preorder.size() == 0 || inorder.size() == 0)
      return NULL;
    return traversal(preorder, inorder);
  }
};