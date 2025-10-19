class Solution {
    public int lengthOfLongestSubstring(String s) {
        // maxlen
        int maxlen = 0;
        int len = s.length();

        // 128 ascii code
        int[] counts = new int[128];

        // two-pointer (left, right)
        int left = 0, right = 0;

        // increase right
        while(right < len) {
            counts[s.charAt(right)]++;
            
            // if duplicated, than increase left
            while(counts[s.charAt(right)] > 1 && left <= right) {
                counts[s.charAt(left)]--;
                left++;
            }

            // compare length
            maxlen = Math.max(maxlen, right - left + 1);

            right++;
        }
        // return
        return maxlen;
    }
}