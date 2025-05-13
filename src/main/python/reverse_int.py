class Solution:
    # 7. Reverse integer without overflow
    def reverse(self, x: int) -> int:
        final = 0
        num = abs(x)
        sign = -1 if x<0 else 1
        MAX_RANGE = 2**31-1

        while num!=0:
            md = num % 10
            num = num // 10
            
            if final > (MAX_RANGE - md)//10:
                return 0

            final = (final*10)+md

        return sign * final

s = Solution()
res = s.reverse(2)

print(res)