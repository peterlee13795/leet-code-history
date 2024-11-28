class Solution {
    public int longestSubarray(int[] nums) {
        int deleteCount = 0;
        
        int rightIndex = 0, leftIndex = 0;
        
        int len = nums.length;
        int max = 0;
        while(rightIndex < len) {
            
            if(nums[rightIndex] == 0) {
                deleteCount++;
            }
            
            while(deleteCount == 2) {
                if(nums[leftIndex++] == 0) {
                    deleteCount--;
                }
            }
            
            
            max = Math.max(max, rightIndex - leftIndex);
            rightIndex++;
        }
        return max;
    }
}