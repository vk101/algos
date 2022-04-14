#include <stdio.h>
#include <string.h>

// https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1

int main(int argc, char *argv[]) {

    printf("Input: %s\n", argv[1]);
    char *s = argv[1];

    /*
        Find all the palindromes taking one at a time
        Store is cache
        To check for 3+ chars, use previous results
    */

   int len = strlen(s);
   int cache[len][len];

    for(int i=0;i<len;i++) {
       for(int j=0; j<len; j++) {
           cache[i][j]=0;
       }
    }  

   for(int i=0;i<len;i++) {
       for(int j=i; j<len; j++) {
           if(i==0) {
               cache[i][j] = 1;
           }
           else {
               if(s[j-i] == s[j]) {
                   if(i>1 && cache[i-2][j-1]==1) {
                       cache[i][j] = 1;
                   } else if (i==1) {
                       cache[i][j] = 1;
                   }
               }
           }
       }
   }

   for(int i=0;i<len;i++) {
       for(int j=0; j<len; j++) {
           if(cache[i][j] == 1) {
               for(int t=j-i;t<=j;t++) {
                   printf("%c", s[t]);
               }
               printf("\n");
           }
       }
   }
}