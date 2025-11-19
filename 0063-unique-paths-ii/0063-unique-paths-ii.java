class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 만약 시작점이 장애물이라면 경로 없음
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;  // 시작점

        // 첫 행 초기화 (i = 0)
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[j] = 0;
            } else {
                dp[j] = dp[j - 1];  // 왼쪽에서만 올 수 있음
            }
        }

        // 이후 행 반복
        for (int i = 1; i < m; i++) {
            // 첫 열 처리 (j = 0)
            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;  // 이 열은 장애물이 생기면 경로 없음
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[n -1];

    }
}