# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sub = [1]
        visited = set()
        max = 0
        curr = 0
        for i in range(len(s)):
            if s[i] not in visited:
                curr += 1
            else:
                max = max if max>curr else curr
                curr = 1
                visited = set()
            visited.add(s[i])
        return max
        
if __name__ == '__main__':
    s = "pwwkew"
    o = Solution()
    max = o.lengthOfLongestSubstring(s)
    
    print("Result found: %d" % max)
