class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 홀수 길이 팰린드롬 중심: i
            int len1 = expandAroundCenter(s, i, i);
            // 짝수 길이 팰린드롬 중심: i, i+1
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                // 새로 찾은 팰린드롬이 더 길면 업데이트
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // while에서 한 번 넘어서니까 실제 길이는 (right-1) – (left+1) + 1 = right - left - 1
        return right - left - 1;
    }

}
