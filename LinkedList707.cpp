#include <stddef.h>
#include <iostream>
using namespace std;

class MyLinkedList
{
public:
  struct LinkedNode
  {
    int val;
    LinkedNode *next;
    LinkedNode(int val) : val(val), next(nullptr) {}
  };
  MyLinkedList()
  {
    // 这里定义的头结点 是一个虚拟头结点
    _dummyHead = new LinkedNode(0);
    _size = 0;
  }

  int get(int index)
  {
    if (index > _size - 1 || index < 0)
      return -1;
    LinkedNode *cur = _dummyHead->next;
    while (index--)
    {
      cur = cur->next;
    }
    return cur->val;
  }

  void addAtHead(int val)
  {
    LinkedNode *newNode = new LinkedNode(val);
    newNode->next = _dummyHead->next;
    _dummyHead->next = newNode;
    _size++;
  }

  void addAtTail(int val)
  {
    LinkedNode *newNode = new LinkedNode(val);
    LinkedNode *cur = _dummyHead;
    while (cur->next != nullptr)
    {
      cur = cur->next;
    }
    cur->next = newNode;
    _size++;
  }
  // 在第index个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
  // 如果index 等于链表的长度，则说明是新插入的节点为链表的尾结点
  // 如果index大于链表的长度，则返回空
  void addAtIndex(int index, int val)
  {
    if (index > _size){
      return;
    }
    LinkedNode *newNode = new LinkedNode(val);
    LinkedNode *cur = _dummyHead;
    while (index--)
    {
      cur = cur->next;
    }
    newNode->next = cur->next;
    cur->next = newNode;
    _size++;
  }
  // 删除第index个节点，如果index 大于等于链表的长度，直接return，注意index是从0开始的
  void deleteAtIndex(int index)
  {
    if (index >= _size || index < 0){
      return;
    }
    LinkedNode *cur = _dummyHead;
    while (index--)
    {
      cur = cur->next;
    }
    LinkedNode *tmp = cur->next;
    cur->next = cur->next->next;
    delete tmp;
    _size--;
  }
  void printLinkedList()
  {
    LinkedNode *cur = _dummyHead;
    while (cur->next != nullptr)
    {
      cout << cur->next->val << " ";
      cur = cur->next;
    }
    cout << endl;
  }

private:
  int _size;
  LinkedNode *_dummyHead;
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */