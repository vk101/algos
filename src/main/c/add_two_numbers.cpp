// https://leetcode.com/problems/add-two-numbers/
#include <iostream>
using namespace std;

 struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
 };
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {

        int carry = 0;

        ListNode* prev = NULL;
        ListNode* result = NULL;

        while (l1!=NULL && l2!=NULL) {
            int t = l1->val + l2->val;
            t+=carry;
            ListNode* tnode = new ListNode(t%10);
            if(prev!=NULL) {
                prev->next = tnode;
            } else {
                result = tnode;
            }
            prev = tnode;

            carry = t/10;

            //cout << "carry: " << carry << " val: " << tnode->val << endl;

            l1 = l1->next;
            l2 = l2->next;

        }

        ListNode* rem = l1;
        if(l2!=NULL) {
            rem = l2;
        }

        while(rem!=NULL) {
            int t = rem->val + carry;
            
            ListNode* tnode = new ListNode(t%10);
            prev->next = tnode;
            prev = tnode;

            carry = t/10;
            rem = rem->next;
        }

        while(carry>0) {
            ListNode* tnode = new ListNode(carry);
            prev->next = tnode;
            carry = 0;
        }

        return result;
    }
};

void print(ListNode* ll) {
    ListNode* t = ll;
    while(t != NULL) {
        cout << t->val << endl;
        t = t->next;
    }
}

ListNode* createlist(int arr[], int size) {
    ListNode* l1n = NULL;
    ListNode* p = NULL;
    for(int i=0;i<size;i++) {
        ListNode* n = new ListNode(arr[i]);
        if(p !=NULL) {
            p->next = n;
        } else {
            l1n = n;
        }
        p = n;
    }

    return l1n;
}

int main() {

    Solution s = Solution();

    int l1[7] = {9,9,9,9,9,9,9};
    int l2[4] = {9,9,9,9};

    int size = sizeof(l1)/sizeof(l1[0]);
    ListNode* l1n = createlist(l1, size);
    print(l1n);

    size = sizeof(l2)/sizeof(l2[0]);
    ListNode* l2n = createlist(l2, size);

    cout << "----------" << endl;
    print(l2n);

    ListNode* res = s.addTwoNumbers(l1n, l2n);

    cout << "----------" << endl;
    print(res);

    return 0;

}