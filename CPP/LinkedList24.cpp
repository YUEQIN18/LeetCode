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
  ListNode *swapPairs(ListNode *head)
  {
    ListNode *dummyHead = new ListNode(0); // 设置一个虚拟头结点
    dummyHead->next = head;                // 将虚拟头结点指向head，这样方面后面做删除操作
    ListNode *cur = dummyHead;
    // c->1->2->3->4
    while (cur->next != nullptr && cur->next->next != nullptr)
    {
      ListNode *tmp1 = cur->next;
      ListNode *tmp3 = cur->next->next->next;
      // c->2
      cur->next = cur->next->next;
      // 2->1
      cur->next->next = tmp1;
      // 1->3
      cur->next->next->next = tmp3;
      // move cur
      cur = cur->next->next;
    }
    return dummyHead->next;
  }
};