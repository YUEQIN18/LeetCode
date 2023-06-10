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
// 这里注意，我这里定义的是左闭右闭区间，在不断分割的过程中，也会坚持左闭右闭的区间
class Solution
{
private:
  TreeNode *traversal(vector<int> &nums, int left, int right)
  {
    if (left > right)
      return nullptr;
    int mid = left + ((right - left) / 2);
    TreeNode *root = new TreeNode(nums[mid]);
    root->left = traversal(nums, left, mid - 1);
    root->right = traversal(nums, mid + 1, right);
    return root;
  }

public:
  TreeNode *sortedArrayToBST(vector<int> &nums)
  {
    TreeNode *root = traversal(nums, 0, nums.size() - 1);
    return root;
  }
};

/*
// 迭代法可以通过三个队列来模拟，一个队列放遍历的节点，一个队列放左区间下表，一个队列放右区间下表。
// 模拟的就是不断分割的过程
class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if (nums.size() == 0) return nullptr;

        TreeNode* root = new TreeNode(0);   // 初始根节点
        queue<TreeNode*> nodeQue;           // 放遍历的节点
        queue<int> leftQue;                 // 保存左区间下表
        queue<int> rightQue;                // 保存右区间下表
        nodeQue.push(root);                 // 根节点入队列
        leftQue.push(0);                    // 0为左区间下表初始位置
        rightQue.push(nums.size() - 1);     // nums.size() - 1为右区间下表初始位置

        while (!nodeQue.empty()) {
            TreeNode* curNode = nodeQue.front();
            nodeQue.pop();
            int left = leftQue.front(); leftQue.pop();
            int right = rightQue.front(); rightQue.pop();
            int mid = left + ((right - left) / 2);

            curNode->val = nums[mid];       // 将mid对应的元素给中间节点

            if (left <= mid - 1) {          // 处理左区间
                curNode->left = new TreeNode(0);
                nodeQue.push(curNode->left);
                leftQue.push(left);
                rightQue.push(mid - 1);
            }

            if (right >= mid + 1) {         // 处理右区间
                curNode->right = new TreeNode(0);
                nodeQue.push(curNode->right);
                leftQue.push(mid + 1);
                rightQue.push(right);
            }
        }
        return root;
    }
};