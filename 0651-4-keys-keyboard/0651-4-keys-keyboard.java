class Solution {
    public int maxA(int n) {
    // init dp[n]
    if(n == 1) return 1;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;

    // iterate 3~n
    for(int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + 1;
      // iterate 1~n-2
      for(int j = 1; j <= i - 3; j++) {
        // dp[i] = max(dp[i], dp[j] * (n - j))
        dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
      }
    }
    // return dp[n]
    return dp[n];
  }

}