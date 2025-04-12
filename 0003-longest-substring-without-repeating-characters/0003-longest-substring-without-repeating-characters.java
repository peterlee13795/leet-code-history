class Solution {
    public int lengthOfLongestSubstring(String s) {
    int[] index = new int[128]; // ASCII 문자 기준
    int maxLength = 0;
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        // 중복 문자가 있으면 left 갱신
        left = Math.max(index[c], left);
        maxLength = Math.max(maxLength, right - left + 1);
        index[c] = right + 1; // 인덱스를 1-based로 저장
    }

    return maxLength;
}
}