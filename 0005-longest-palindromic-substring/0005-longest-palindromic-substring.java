class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // 홀수 길이 팰린드롬
            int len1 = expandFromCenter(s, i, i);
            // 짝수 길이 팰린드롬
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            // 더 긴 팰린드롬이면 start와 end 갱신
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // 팰린드롬인지 좌우로 확장하며 확인하는 함수
    private int expandFromCenter(String s, int left, int right) {
        // 좌우 문자 비교하며 같으면 계속 확장
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 실제 팰린드롬 길이 반환
        return right - left - 1;
    }
}
