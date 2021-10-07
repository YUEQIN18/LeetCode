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
  ListNode *removeNthFromEnd(ListNode *head, int n)
  {
    ListNode *dummyHead = new ListNode(0);
    dummyHead->next = head;
    ListNode *fast = dummyHead;
    ListNode *slow = dummyHead;
    // move fast n+1 step
    fast = fast->next;
    while (n-- && fast != nullptr)
    {
      fast = fast->next;
    }
    // move fast and slow untill nullptr
    while (fast != nullptr)
    {
      fast = fast->next;
      slow = slow->next;
    }
    slow->next = slow->next->next;
    return dummyHead->next;
  }
};