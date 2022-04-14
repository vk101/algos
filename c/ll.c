#include <stdio.h>
#include <stdlib.h>

//cc -o <out_file> file.c
// ./out_file
struct Node{
    int data;
    struct Node* next;
};

int main() {
    struct Node* head = (struct Node*)malloc(sizeof(struct Node));

    int data[4] = {3,2,1,4};

    struct Node* prev = head;
    for(int i=0;i<4;i++) {
        struct Node* n = (struct Node*)malloc(sizeof(struct Node));
        n->data = data[i];
        n->next = NULL;
        prev->next = n;
        prev = n;
    }

    struct Node* t = head;
    while(t != NULL) {
        printf("%d \n", t->data);
        t = t->next;
    }


    return 0;
}