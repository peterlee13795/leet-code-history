class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    /**
     * 아이디어
     *  dp
     *  dp[i][j] = dp[i-1][j] + dp[i][j - 1]
     */
    // 초기화 (길이, dp)
    int r = obstacleGrid.length;
    int c = obstacleGrid[0].length;
    int[][] dp = new int[r][c];
    if (dp[0][0] == 1) {
      return 0;
    }

    // y축, x축 = 0
    for (int i = 0; i < r; i++) {
      if (obstacleGrid[i][0] == 1) {
        break;
      }
      dp[i][0] = 1;
    }
    for (int i = 0; i < c; i++) {
      if (obstacleGrid[0][i] == 1) {
        break;
      }
      dp[0][i] = 1;
    }

    // grid 반복 & dp 입력
    for (int i = 1; i < r; i++) {
      for (int j = 1; j < c; j++) {
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        if (obstacleGrid[i][j] == 0) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }

    return dp[r - 1][c - 1];
  }
}