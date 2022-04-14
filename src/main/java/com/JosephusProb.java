package com;

public class JosephusProb {
	/*
	 * Solution:
	 * https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/#:~:text=In%20computer%20science%20and%20mathematics,circle%20waiting%20to%20be%20executed.&text=In%20each%20step%2C%20a%20certain,the%20next%20person%20is%20executed.
	 */
		
	static int josephus(int n, int k)
    {
        if (n == 1)
            return 1;
        else
            /* The position returned by josephus(n - 1, k)
            is adjusted because the recursive call
            josephus(n - 1, k) considers the original
            position k%n + 1 as position 1 */
            return (josephus(n - 1, k) + k - 1) % n + 1;
    }
 
    // Driver Program to test above function
    public static void main(String[] args)
    {
        int n = 6;
        int k = 2;
        System.out.println("The chosen place is "
                           + josephus(n, k));
    }
}
