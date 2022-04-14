#include <iostream>
#include <stack>
using namespace std;

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
    Node(int v) : data(v), left(nullptr), right(nullptr) {}
    Node(int v, Node *l, Node *r) : data(v), left(l), right(r) {}
};

void dfs(Node *node) {

    if (node->left == NULL && node->right == NULL) {
        cout << node->data << endl;
        return;
    }
    dfs(node->left);
    cout << node->data << endl;
    dfs(node->right);
}

void dfs_iterative(Node *n1) {
    stack<Node*> stack;

    Node *t = n1;
    while(t != NULL) {
        //cout << t->data << endl;
        if(t->left == NULL) {
            cout << "child: " << t->data << endl;
            if(t->right == NULL) {
                if(stack.size() == 0) break;

                Node *p = stack.top();
                stack.pop();

                cout << "root: " << p->data << endl;
                while(p->right == NULL && stack.size()>0) {
                    p = stack.top();
                    stack.pop();
                }
                t = p->right;
            } else {
                t = t->right;
            }
        } else {
            stack.push(t);
            t = t->left;
        }
    }
}

int main() {

    Node *o2 = new Node(2);
    Node *o4 = new Node(4);
    Node *o3 = new Node(3, o2, o4);
    Node *o6 = new Node(6);
    Node *bs1 = new Node(5, o3, o6);

    Node *s6 = new Node(6);
    Node *s7 = new Node(7, s6, nullptr);
    Node *s3 = new Node(3, nullptr, s7);
    Node *s1 = new Node(1);
    Node *bs2 = new Node(2, s1, s3);

    //dfs(bs1);
    dfs_iterative(bs2);

}