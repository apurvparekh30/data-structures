import java.util.Arrays;

// Java program to memoize 
// recursive implementation of LCS problem 
class Solution {

    static final int maximum = 1000;

    // Returns length of LCS for X[0..m-1], Y[0..n-1] */ 
    // memoization applied in recursive solution 
    /* 	static int lcs(String X, String Y, int m, int n, int dp[][]) { 
    		// base case 
    		if (m == 0 || n == 0) { 
    			return 0; 
    		} 

    		// if the same state has already been 
    		// computed 
    		if (dp[m][n] != -1) { 
    			return dp[m][n]; 
    		} 

    		// if equal, then we store the value of the 
    		// function call 
    		if (X.charAt(m - 1) == Y.charAt(n - 1)) { 

    			// store it in arr to avoid further repetitive 
    			// work in future function calls 
    			dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp); 

    			return dp[m][n]; 
    		} else { 

    			// store it in arr to avoid further repetitive 
    			// work in future function calls 
    			dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp), 
    					lcs(X, Y, m - 1, n, dp)); 

    			return dp[m][n]; 
    		} 
    	}  */
    static int[][] dp;

    static int LCS(int i, int j, char[] x, char[] y) {
        if (i == 0 || j == 0) {
            return (0);
		}
        if (dp[i][j] != -1) {
            return (dp[i][j]); 
        }
        if (x[i - 1] == y[j - 1]) {
            dp[i][j] = LCS(i - 1, j - 1, x, y) + 1;

            return dp[i][j];
        } else {
            dp[i][j] = Math.max(LCS(i - 1, j, x, y),LCS(i, j - 1, x, y));
			return dp[i][j];
        }
    }


    // Driver Code 
    public static void main(String[] args) {
        String X = "JJUD";
        String Y = "UUPD";
        int m = X.length();
        int n = Y.length();

        dp = new int[m + 1][n + 1];

        // assign -1 to all positions 
        for (int[] row: dp) {
            Arrays.fill(row, -1);
		}
		


		System.out.println("Length of LCS: " + LCS(m, n, X.toCharArray(), Y.toCharArray()));
		
		for (int[] row: dp) {
            System.out.println(Arrays.toString(row));
		}
    }
}
/* This Java code is contributed by 29AjayKumar*/