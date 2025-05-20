from typing import List

class Solution:

    # Using bottom up approach, at a given point find all the possible paths from the row above, 
    # and taking the maximum score based on all tried.
    # Time Complexity - O(r.c^2)
    # This can be optimized to O(r.c)
    # At every row, 
    #     Identify the maximum from left to right, where 0th column score will be that of the previous row, take max of left[col-1] and previous[col]
    #     Identify the maximum from right to left, where, last column score will be that of the previous row, take max of right[col+1] and previous[col]
    #     At every move, left-to-right, or right-to-left, 1 is removed to consider the distance
    # Final score at 'col' is determined by taking the maximum out of left[col] and right[col]
    def maxPoints(self, points: List[List[int]]) -> int:
        cols = len(points[0])
        
        previous_row = points[0]
        for row in points[1:]:
            current_row = [0]*cols

            left_max = [0] * cols
            left_max[0] = previous_row[0]
            for col in range(1, cols):
                left_max[col] = max(left_max[col-1]-1, previous_row[col])

            right_max = [0] * cols
            right_max[-1] = previous_row[-1]
            for col in range(cols-2, -1, -1):
                right_max[col] = max(right_max[col+1]-1, previous_row[col])
            
            for col in range(cols):
                current_row[col] = max(left_max[col], right_max[col]) + row[col]
            previous_row = current_row

        return max(previous_row)


    # Simple Top-Down DP approach, where all the possible combinations are tried, with memoization.
    # Time complexity exponential

    def maxPoints_DpTimeOut(self, points: List[List[int]]) -> int:
        
        rows = len(points)
        cols = len(points[0])
        memo = [[-1 for _ in range(cols)] for _ in range(rows)]

        def backtrack(r: int, c: int):
            if r>=rows or c>=cols: return 0

            if memo[r][c]>-1:
                return memo[r][c]

            max_score = 0
            for col in range(cols):
                ts = backtrack(r+1, col) + points[r][col] - abs(col-c)
                max_score = max(max_score, ts)
            memo[r][c] = max_score

            return max_score
         
        max_score = 0
        for col in range(cols):
            max_score = max(backtrack(0, col), max_score)
        
        return max_score

# input = [[1,2,3],[1,5,1],[3,1,1]] #9
input = [[1,5],[2,3],[4,2]] #11
s = Solution()
res = s.maxPoints(input)

print(res)