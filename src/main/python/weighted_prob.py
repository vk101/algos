from typing import List
import random
import bisect

class Solution:

    # 528 - Random pick with weight
    #   Intuition:
    #       Ex: [2,3,5]
    #   Weighted distribution of index will be:
    #       index_arr = [0, 0, 1, 1, 1, 2, 2, 2, 2, 2]
    #   Then get a random number (since it has a uniform probability) from 0 to len(index_arr)-1
    #       return index_arr[random_index] found above
    #   The problem with this approach is space, as index_arr can be big when number list has large numbers
    #   How to reduce the space:
    #       Find bounds using indices in the index_arr = [0, 0, 1, 1, 1, 2, 2, 2, 2, 2]
    #       0<=n<2  -> index 0
    #       2<=n<5  -> index 1
    #       5<=n<10 -> index 2
    #       Condensed version of index_arr with prefix sum will be [2, 5, 10]
    #   We need to generate a random number from 0 to 10, and check in which bucket it lies.
    #   This can be performed using Binary Search for O(log n) time complexity

    #
    # This implementation is doing the same thing, but with weights instead of actual values, so that
    # lower and upper bound is 0 to 1
    #
    def __init__(self, w: List[int]):
        total = sum(w)
        self.prefix_wt = w

        for i in range(len(w)):
            self.prefix_wt[i] = w[i]/total
        for i in range(1, len(w)):
            self.prefix_wt[i] += self.prefix_wt[i-1]

    def pickIndex(self) -> int:
        
        predicted = random.uniform(0,1)
        return bisect.bisect_left(self.prefix_wt, predicted)

        # without binary search
        # index = 0
        # while predicted > self.prefix_wt[index]:
        #     index+=1
        # return index
    
s = Solution([1,3])
res = s.pickIndex()
print(res)

res = s.pickIndex()
print(res)
