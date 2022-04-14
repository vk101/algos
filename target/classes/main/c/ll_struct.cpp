#include <iostream>
using namespace std;

 struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
 };

int main() {
    struct ListNode* head = new ListNode();
    int data[4] = {3,2,1,4};

    ListNode* prev = head;
    for(int i=0;i<4;i++) {
        struct ListNode* n = new ListNode(data[i]);
        prev->next = n;
        prev = n;
    }

    ListNode* t = head;
    while(t != NULL) {
        cout << t->val << endl;
        t = t->next;
    }

    return 0;

}