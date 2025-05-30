class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] characters = s.toCharArray();
        int distinctStartIndex = 0;
        int distinctCharacterCount = 0;
        int maxLength = 0;
        int[] characterCounts = new int[128];
        for(int distinctEndIndex = 0, len = characters.length; distinctEndIndex < len; distinctEndIndex++) {
            char character = characters[distinctEndIndex];
            if(characterCounts[character]++ == 0) distinctCharacterCount++;

            if(distinctCharacterCount > k) {
                while(--characterCounts[characters[distinctStartIndex++]] > 0);
                distinctCharacterCount--;
            }
            maxLength = Math.max(maxLength, distinctEndIndex - distinctStartIndex + 1);
        }

        return maxLength;
    }
}