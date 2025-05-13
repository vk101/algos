class Solution:
    
    # 3335. Total Characters in String After Transformations I
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        mod = 10**9 + 7

        freq = [0]*26
        for c in s:
           freq[ord(c)-ord('a')] += 1

        for i in range(t):
            tmp = [0]*26
            for r in range(26):
                if r == 25:
                    tmp[0] = (tmp[0] + freq[r]) % mod
                    tmp[1] = (tmp[1] + freq[r]) % mod
                else:
                    tmp[r+1] = (tmp[r+1] + freq[r]) % mod
            freq = tmp
        return sum(freq) % mod

s = Solution()
res = s.lengthAfterTransformations('azbk',1)
print(res)