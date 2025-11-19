class Solution {
    public int minPathSum(int[][] grid) {
        // init m, n
        int m =grid.length;
        int n = grid[0].length;

        // int[][] dp
        int[][] dp = new int[m][n];
        // dp[0][0] = grid[0][0]
        dp[0][0] = grid[0][0];

        // init i=1
        // dp[0][i] = dp[0][i-1] + grid[0][i]
        for(int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // init y=1
        // dp[y][0] = dp[y-1][0] = grid[y][0]
        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // iterate y,x
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                // dp[i][j] = grid[i][j] + math.min(dp[i-1][j], dp[i][j-1])
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        // return dp[m-1][n-1]
        return dp[m-1][n-1];
    }
}
