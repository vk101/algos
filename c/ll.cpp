#include <iostream>
using namespace std;

//g++ -o <out_file> file.cpp
// ./out_file
class Node {
    public:
        int data;
        Node* next;
};

int main() {
    Node* head = new Node();

    int data[4] = {3,2,1,4};

    Node* prev = head;
    for(int i=0;i<4;i++) {
        Node* n = new Node();
        n->data = data[i];
        n->next = NULL;
        prev->next = n;
        prev = n;
    }

    Node* t = head;
    while(t != NULL) {
        cout << t->data << endl;
        t = t->next;
    }

    return 0;
}