class Solution {
    public int climbStairs(int n) {
        // D[n] = D[n-1] * 2;
        // if(i + 2 > n) D[i] = D[i-1];
        // else D[i] = D[i-2] + D[i-1];
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
        
    }
}