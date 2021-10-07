/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
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
  ListNode *getIntersectionNode(ListNode *headA, ListNode *headB)
  {
    ListNode *curA = headA;
    ListNode *curB = headB;
    int lenA = 0, lenB = 0;
    // 求链表A的长度
    while (curA != nullptr)
    {
      lenA++;
      curA = curA->next;
    }
    // 求链表B的长度
    while (curB != nullptr)
    {
      lenB++;
      curB = curB->next;
    }
    // start
    curA = headA;
    curB = headB;
    // 让curA为最长链表的头，lenA为其长度
    if (lenB > lenA)
    {
      swap(lenA, lenB);
      swap(curA, curB);
    }
    int gap = lenA - lenB;
    // 让curA和curB在同一起点上（末尾位置对齐）
    while (gap--)
    {
      curA = curA->next;
    }
    while (curA != nullptr)
    {
      if (curA == curB)
      {
        return curA;
      }
      curA = curA->next;
      curB = curB->next;
    }
    return NULL;
  }
};