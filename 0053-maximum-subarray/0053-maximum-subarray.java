class Solution {
    public int maxSubArray(int[] nums) {
         // 초기화(index별 최대값, 전체최대값)
         int currMax = nums[0];
         int totalMax = nums[0];

         // 반복문 (1~n)
         for(int i = 1, len = nums.length; i < len; i++) {
            // 현재최대 = math.max(현재최대, 현재최대 + nums[현재인덱스])
            currMax = Math.max(nums[i], currMax + nums[i]);
            // 전체최대 = math.max(전체최대, 현재최대)
            totalMax = Math.max(totalMax, currMax);
         }

        // 전체최대
        return totalMax;
    }
}