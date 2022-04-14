if __name__ == "__main__":
    seq1 = "AGGTAB"
    seq2 = "GXTXAYB"

    #seq1 = "ABCDGH"
    #seq2 = "AEDFHR"

    s1 = len(seq1)
    s2 = len(seq2)
    
    #print("{}, {}".format(s1, s2))

    dp=[]
    for t in range(s2+1):
        dp.append([0 for c in range(s1+1)])

    #print(dp)

    for r in range(s2+1):
        for c in range(s1+1):
            if r == 0 or c == 0:
                dp[r][c] = 0
            elif seq2[r-1] == seq1[c-1]:
                dp[r][c] = dp[r-1][c-1]+1
            else:
                dp[r][c] = max(dp[r-1][c], dp[r][c-1])
                
    print(dp[s2][s1])
