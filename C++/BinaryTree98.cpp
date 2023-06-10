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
  void traversal(TreeNode *cur, vector<int> &nums)
  {
    if (cur == nullptr)
      return;
    traversal(cur->left, nums);
    nums.push_back(cur->val);
    traversal(cur->right, nums);
  }

  bool isValidBST(TreeNode *root)
  {
    vector<int> nums;
    traversal(root, nums);
    for (int i = 0; i < nums.size() - 1; i++)
    {
      if (nums[i] >= nums[i + 1])
        return false;
    }
    return true;
  }
};

/* 另一种方法
class Solution {
public:
    TreeNode* pre = NULL; // 用来记录前一个节点
    bool isValidBST(TreeNode* root) {
        if (root == NULL) return true;
        bool left = isValidBST(root->left);

        if (pre != NULL && pre->val >= root->val) return false;
        pre = root; // 记录前一个节点

        bool right = isValidBST(root->right);
        return left && right;
    }
};

迭代法验证二叉搜索树

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        stack<TreeNode*> st;
        TreeNode* cur = root;
        TreeNode* pre = NULL; // 记录前一个节点
        while (cur != NULL || !st.empty()) {
            if (cur != NULL) {
                st.push(cur);
                cur = cur->left;                // 左
            } else {
                cur = st.top();                 // 中
                st.pop();
                if (pre != NULL && cur->val <= pre->val)
                return false;
                pre = cur; //保存前一个访问的结点

                cur = cur->right;               // 右
            }
        }
        return true;
    }
};
*/
