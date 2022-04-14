#include <stdio.h>

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
int find_max_recur(int W, int *value, int *weight, int size, int start) {

    if(start>size-1) {
        return 0;
    }
    if(W<0) {
        return 0;
    }

    int max = 0;
    for (int i=start; i<size; i++) {
        if (weight[i] > W) continue;
        int temp = value[i] + find_max_recur(W-weight[i], value, weight, size, i+1);
        max = max<temp?temp:max;
    }

    return max;
}

int max(int a, int b) {
    return a>b?a:b;
}

void print(int *arr, int W) {

    for(int j=0; j<=W; j++) {
        printf("%d ", arr[j]);
    }
    printf("\n");
}

int find_max_dp(int W, int *value, int *weight, int size) {

    int cache[size+1][W+1];

    for (int i = 0; i <= size; i++)
    {
        for (int w = 0; w <= W; w++)
        {
            if (i==0 || w==0) {
                cache[i][w] = 0;
            }
            else if(w >= weight[i-1]) {
                cache[i][w] = max(cache[i-1][w], cache[i-1][w-weight[i-1]] + value[i-1]);
            }
            else {
                cache[i][w] = cache[i-1][w];
            }
        }
        //print(cache[i], W);
    }

    return cache[size][W];
}

int main() {

    int value[] = {60 ,100, 120};
    int weight[] = {10, 20, 30};
    int W = 50;

    //int max = find_max_recur(W, value, weight, sizeof(value)/sizeof(int), 0);
    int max = find_max_dp(W, value, weight, sizeof(value)/sizeof(int));
    printf("Max weight: %d\n", max);
}