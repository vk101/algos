#include <stdio.h>

// https://leetcode.com/problems/container-with-most-water/

int main() {

    int height[] = {1,1}; //{1,8,6,2,5,4,8,3,7};
    int size = sizeof(height)/sizeof(height[0]);

    int i=0,j=size-1;
    int max = 0;

    while(i<j) {
        int h = height[i]>height[j]?height[j]:height[i];
        int l = j-i;
        int area = h*l;
        max = max>area?max:area;

        int f = 0;
        if(i<size-1 && (height[i+1]-height[i]) > i+1) { i++; f=1; }
        if(j>0 && (height[j-1]-height[j]) > size-j) { j--; f=1; }
        
        if(f==0) {
            if(height[i]<height[j])
                i++;
            else 
                j--;
        }
    }
    printf("Area: %d \n", max);
}