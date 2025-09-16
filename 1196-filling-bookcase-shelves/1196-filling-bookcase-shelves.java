class Solution {
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1]; // dp[i]는 i번째 책까지의 최소 높이
        
        dp[0] = 0; // 책이 없을 때 높이는 0

        for (int i = 1; i <= n; i++) {
            int width = 0; // 현재 선반의 사용된 폭
            int height = 0; // 현재 선반의 최대 높이
            dp[i] = Integer.MAX_VALUE; // 초기화

            // i번째 책을 포함하여 가능한 모든 배치를 시도
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0]; // j번째 책의 두께 추가
                if (width > shelfWidth) break; // 선반 폭 초과 시 중단
                
                height = Math.max(height, books[j - 1][1]); // 최대 높이 갱신
                dp[i] = Math.min(dp[i], dp[j - 1] + height); // 최적 높이 갱신
            }
        }

        return dp[n]; // 모든 책을 배치한 최소 높이 반환
    }
}