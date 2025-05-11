from typing import List

# 1550, Easy, Three Consecutive Odds
class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        for i in range(2, len(arr)):
            if arr[i]%2!=0 and arr[i-1]%2!=0 and arr[i-2]%2!=0:
                return True
        return False

arr = [1,2]
s = Solution()
res = s.threeConsecutiveOdds(arr)

print(res)