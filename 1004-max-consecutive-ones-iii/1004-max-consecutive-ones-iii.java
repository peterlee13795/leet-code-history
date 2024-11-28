class Solution {
    public int longestOnes(int[] nums, int k) {
        int rightIndex = 0, leftIndex = 0;
        int max = 0;
        
        int len = nums.length;
        int zeroCount = 0;
        while(rightIndex < len) {
            if(nums[rightIndex] == 0) {
                zeroCount++;
            }
            
            while(zeroCount > k) {
                if(nums[leftIndex++] == 0) {
                    zeroCount--;
                }
            }
            
            max = Math.max(max, rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return max;
    }
}