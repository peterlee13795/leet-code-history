class Solution {
    public int[] twoSum(int[] nums, int target) {
        // sort n * logn
        // Arrays.sort(nums);

        // two-pointer n^2
        int len = nums.length;
        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                if(nums[i] + nums[j] == target) return new int [] {i, j};
            }
        }
        return null;


    }
}