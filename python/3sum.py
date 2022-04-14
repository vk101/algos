# https://leetcode.com/problems/3sum/
if __name__ == '__main__':
    nums = [-1,0,1,2,-1,-4]

    # populate two sums first
    size = len(nums)
    two_s = [0 for i in range(size)]


    for r in range(size):
        two_s[r] = [-1 for i in range(size)]
        for c in range(r+1, size):
            two_s[r][c] = nums[r]+nums[c]

    cache = {}
    # calculate 3 sums by using two sums result and one element from input array at a time
    for t in range(size):
        for p in range(t+1, size):
            for q in range(p+1, size):
                if two_s[p][q]+nums[t] == 0:

                    # to remove duplicate triplets
                    v = [nums[t], nums[p], nums[q]]
                    v.sort()
                    found = 0
                    
                    if v[0] in cache and v[1] in cache[v[0]] and cache[v[0]][v[1]] == v[2]:
                        found = 1
                    elif v[0] in cache and v[1] in cache[v[0]] and v[2] not in cache[v[0]][v[1]]:
                        cache[v[0]][v[1]] = v[2]
                    elif v[0] in cache and v[1] not in cache[v[0]]:
                        cache[v[0]].update({v[1] : v[2]})
                    elif v[0] not in cache:
                        cache[v[0]] = {v[1] : v[2]}
                    # end of duplication logic #
                    
                    if found == 0:
                        print('[%d, %d, %d]' % (nums[t], nums[p], nums[q]))