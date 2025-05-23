class Solution {
    public String largestNumber(int[] nums) {
        /*
        아이디어
            string compare
        */

        int len = nums.length;

        String[] str = new String[len];
        for(int i= 0 ; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // edge case: 맨 앞이 0이면 모든 수가 0
        if (str[0].equals("0")) return "0";

        
        StringBuilder sb = new StringBuilder();
        for(String s: str) sb.append(s);

        return sb.toString();
    }
}