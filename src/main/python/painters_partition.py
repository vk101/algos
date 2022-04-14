# https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1


def partition_recursion(arr, n, k):
    if n==1:
        return arr[0]
    if k==1:
        return sum(arr)
    
    best = 999999
    # Taking one job at a time for the first painter
    for i in range(1, n):
        p1 = sum(arr[:i])
        # recursively trying to find best time for the rest of the painters
        rest_p = partition_recursion(arr[i:],n-i, k-1)

        #finding the best option, by taking time taken by the first painter and the rest of the painters
        best = min(best, max(p1, rest_p))
    return best

def partition_dp(arr, n, k):

    dp=[]
    for painter in range(0, k+1):
        dp.append([0 for c in range(n+1)])

    # start with 1 painter, painting 1 to n paintings
    # use the above time to calculate when more painters are added
    for painter in range(1, k+1):
        for job in range(1, n+1):
            # when there is only one painter, there is no other option but to 
            # take sum of time taken for all the paintings
            if (painter == 1):
                dp[painter][job] = sum(arr[:job])
            else:
                best = 9999
                # check for every partition, starting from 1st paiting to the last 
                # depending on the number of paintings selected in this iteration
                for p in range(1, job):
                    # dp[painter-1][p] represents the previous best option
                    best = min(best, max(dp[painter-1][p], sum(arr[p:job])))
                dp[painter][job] = best
    return dp[k][n]


if __name__ == '__main__':     
    n = 5
    k = 3
    arr = [5,10,30,20,15]
    '''
    n = 4
    k = 2
    arr = [10,20,30,40]
    '''

    # time = partition_recursion(arr, n, k)
    time = partition_dp(arr, n, k)
    print(time)