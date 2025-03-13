class Solution {
    public int maxA(int n) {
        // dp[n] = math.max(dp[n-1]+1, dp[j] * (i-j-1))

        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2 ; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i-j-1));
            }
        }
        return dp[n];
    }
}