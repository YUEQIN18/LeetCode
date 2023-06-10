/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
#include <stddef.h>
using namespace std;

class Solution
{
public:
  struct ListNode
  {
    int val;
    ListNode *next;
    ListNode(int val) : val(val), next(nullptr) {}
  };
  ListNode *reverseList(ListNode *head)
  {
    ListNode *tmp; // 保存cur的下一个节点
    ListNode *cur = head;
    ListNode *pre = NULL;
    while (cur)
    {
      tmp = cur->next; // 保存一下 cur的下一个节点，因为接下来要改变cur->next
      cur->next = pre; // 翻转操作
      // 更新pre 和 cur指针
      pre = cur;
      cur = tmp;
    }
    return pre;
  }
};