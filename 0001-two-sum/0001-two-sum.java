class Solution {
    public int[] twoSum(int[] nums, int target) {
    int size = nums.length;

    for (int lindex = 0; lindex< size - 1; lindex++) {
      for(int rindex = lindex + 1; rindex < size; rindex++) {
        if(nums[lindex] + nums[rindex] == target) {
          return new int[] {lindex, rindex};
        }
      }
    }
    return new int[]{-1, -1};

  }
}