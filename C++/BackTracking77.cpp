#include <stddef.h>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution
{
private:
  vector<vector<int>> result; // 存放符合条件结果的集合
  vector<int> path;           // 用来存放符合条件结果
  void backtracking(int n, int k, int startIndex)
  {
    if (path.size() == k)
    {
      result.push_back(path);
      return;
    }
    for (int i = startIndex; i <= n; i++)
    {
      path.push_back(i);         // 处理节点
      backtracking(n, k, i + 1); // 递归
      path.pop_back();           // 回溯，撤销处理的节点
    }
  }

public:
  vector<vector<int>> combine(int n, int k)
  {
    result.clear(); // 可以不写
    path.clear();   // 可以不写
    backtracking(n, k, 1);
    return result;
  }
};
/*
// 剪枝优化
// 接下来看一下优化过程如下：
// 已经选择的元素个数：path.size();
// 还需要的元素个数为: k - path.size();
// 在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
// 为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
// 举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
// 从2开始搜索都是合理的，可以是组合[2, 3, 4]

class Solution {
private:
    vector<vector<int>> result;
    vector<int> path;
    void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.push_back(path);
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) { // 优化的地方
            path.push_back(i); // 处理节点
            backtracking(n, k, i + 1);
            path.pop_back(); // 回溯，撤销处理的节点
        }
    }
public:

    vector<vector<int>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
};