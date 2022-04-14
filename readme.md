### Solving dynamic programming problems
#### These are the problem where there are subsets, such that result of a subset can be reused without re-computing

Using memoization:
1. First find a brute force solution to a problem, in most of the cases using recursion.
2. Find subset problems and cache the result of subset problem in a data structure
3. Use the cached result if subset problem reappears

Using tabulation:
1. Visualize the problem as a table
2. Size the table based on inputs
3. Initialize the table with default values
4. Seed the trivial answer to the table
5. Iterate through the table and fill further positions based on the current position

Tips
1. Find overlaps
2. Start with a small input
3. Think recursively to use Memoization
4. Think iteratively to use tabulation
5. Draw the strategy first