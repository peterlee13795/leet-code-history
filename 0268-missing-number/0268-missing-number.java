class Solution {
    public int missingNumber(int[] nums) {
        // len
        boolean[] visits = new boolean[nums.length + 1];

        for(int num: nums) {
            visits[num] = true;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visits[i]) return i;
        }
        return nums.length;
    }
}