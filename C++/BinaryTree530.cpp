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
  void traversal(TreeNode *cur, vector<int> &vec)
  {
    if (cur == nullptr)
      return;
    traversal(cur->left, vec);
    vec.push_back(cur->val); // 将二叉搜索树转换为有序数组
    traversal(cur->right, vec);
  }
  int getMinimumDifference(TreeNode *root)
  {
    vector<int> vec;
    traversal(root, vec);
    if (vec.size() < 2)
      return 0;
    int result = INT_MAX;
    for (int i = 1; i < vec.size(); i++)
    { // 统计有序数组的最小差值
      result = min(result, vec[i] - vec[i - 1]);
    }
    return result;
  }
};

/*
中序遍历的迭代法
class Solution {
public:
    int getMinimumDifference(TreeNode* root) {
        stack<TreeNode*> st;
        TreeNode* cur = root;
        TreeNode* pre = NULL;
        int result = INT_MAX;
        while (cur != NULL || !st.empty()) {
            if (cur != NULL) { // 指针来访问节点，访问到最底层
                st.push(cur); // 将访问的节点放进栈
                cur = cur->left;                // 左
            } else {
                cur = st.top();
                st.pop();
                if (pre != NULL) {              // 中
                    result = min(result, cur->val - pre->val);
                }
                pre = cur;
                cur = cur->right;               // 右
            }
        }
        return result;
    }
};
*/