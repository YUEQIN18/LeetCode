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
  TreeNode *traversal(vector<int> &inorder, int inorderBegin, int inorderEnd, vector<int> &postorder, int postorderBegin, int postorderEnd)
  {
    if (postorderBegin == postorderEnd)
      return NULL;

    int rootValue = postorder[postorderEnd - 1];
    TreeNode *root = new TreeNode(rootValue);

    if (postorderEnd - postorderBegin == 1)
      return root;

    int delimiterIndex;
    for (delimiterIndex = inorderBegin; delimiterIndex < inorderEnd; delimiterIndex++)
    {
      if (inorder[delimiterIndex] == rootValue)
        break;
    }
    // 切割中序数组
    // 左中序区间，左闭右开[leftInorderBegin, leftInorderEnd)
    int leftInorderBegin = inorderBegin;
    int leftInorderEnd = delimiterIndex;
    // 右中序区间，左闭右开[rightInorderBegin, rightInorderEnd)
    int rightInorderBegin = delimiterIndex + 1;
    int rightInorderEnd = inorderEnd;

    // 切割后序数组
    // 左后序区间，左闭右开[leftPostorderBegin, leftPostorderEnd)
    int leftPostorderBegin = postorderBegin;
    int leftPostorderEnd = postorderBegin + delimiterIndex - inorderBegin; // 终止位置是 需要加上 中序区间的大小size
    // 右后序区间，左闭右开[rightPostorderBegin, rightPostorderEnd)
    int rightPostorderBegin = postorderBegin + (delimiterIndex - inorderBegin);
    int rightPostorderEnd = postorderEnd - 1; // 排除最后一个元素，已经作为节点了

    cout << "----------" << endl;
    cout << "leftInorder :";
    for (int i = leftInorderBegin; i < leftInorderEnd; i++)
    {
      cout << inorder[i] << " ";
    }
    cout << endl;

    cout << "rightInorder :";
    for (int i = rightInorderBegin; i < rightInorderEnd; i++)
    {
      cout << inorder[i] << " ";
    }
    cout << endl;

    cout << "leftpostorder :";
    for (int i = leftPostorderBegin; i < leftPostorderEnd; i++)
    {
      cout << postorder[i] << " ";
    }
    cout << endl;

    cout << "rightpostorder :";
    for (int i = rightPostorderBegin; i < rightPostorderEnd; i++)
    {
      cout << postorder[i] << " ";
    }
    cout << endl;

    root->left = traversal(inorder, leftInorderBegin, leftInorderEnd, postorder, leftPostorderBegin, leftPostorderEnd);
    root->right = traversal(inorder, rightInorderBegin, rightInorderEnd, postorder, rightPostorderBegin, rightPostorderEnd);

    return root;
  }

public:
  TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder)
  {
    if (inorder.size() == 0 || postorder.size() == 0)
      return NULL;
    return traversal(inorder, 0, inorder.size(), postorder, 0, postorder.size());
  }
};