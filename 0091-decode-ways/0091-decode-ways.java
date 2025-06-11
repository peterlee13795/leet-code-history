class Solution {
    public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

    int n = s.length();
    int[] dp = new int[n + 1];

    // 초기화
    dp[0] = 1; // 아무 것도 없을 때는 1가지 방법
    dp[1] = 1; // 첫 글자가 0이 아닌 경우 1가지 방법

    for (int i = 2; i <= n; i++) {
      // 한 자리 해독 가능 (1~9)
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }

      // 두 자리 해독 가능 (10~26)
      int twoDigit = Integer.parseInt(s.substring(i - 2, i));
      if (twoDigit >= 10 && twoDigit <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[n];
  }
}