class Solution {
    public int lengthOfLongestSubstring(String s) {
        // init (characterCountMap, longest)
        Map<Character, Integer> characterCountMap = new HashMap<>();
        int longest = 0;

        // two-point iterate
        for(int lidx = 0, ridx = 0, len = s.length(); ridx < len; ridx++) {
            // char
            char c0 = s.charAt(ridx);

            // check char if exist in map
            while(characterCountMap.containsKey(c0)) {
                // remove from left until char found from lindex
                char c1 = s.charAt(lidx++);
                int c1Count = characterCountMap.get(c1);
                if(c1Count == 1) {
                    characterCountMap.remove(c1);
                } else {
                    characterCountMap.put(c1, c1Count - 1);
                }
            }
            characterCountMap.put(c0, characterCountMap.getOrDefault(c0, 0) + 1);

            // get longest (rindex - lindex + 1)
            longest = Math.max(longest, ridx - lidx + 1);
        }
        return longest;
    }
}