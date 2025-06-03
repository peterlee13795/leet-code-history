class Solution {
    public int minDistance(String word1, String word2) {
        // 초기화 (dp 정의)
        // dp: int[i][j] => word1의 i번째 단어가 word2 j번째 단어로 변환되기 까지 필요한 개수
        // dp[0][j], dp[i][j] 초기화
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i =0 ; i <= m ; i++) dp[i][0] = i; // 삭제 only
        for(int j = 0 ; j <= n; j++) dp[0][j] = j; // 삽입 only

        // i,j 반복문
        for(int i = 1 ; i <= m ; i++) {
            for(int j = 1; j <= n ; j++) {
                // word[i][j] == word[i-1][j-1] => continue
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                // 삽입,삭제,교체 중 가장 최소 교체값 찾기
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                dp[i][j] += 1;
            }
        }
        return dp[m][n];
    }
}