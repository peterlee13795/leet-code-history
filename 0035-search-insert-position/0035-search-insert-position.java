class Solution {
    public int searchInsert(int[] nums, int target) {
    // left, right
    int left = 0;
    int right = nums.length - 1;
    // binary search iterate
    while (left <= right) {
      // find mid
      int mid = (right + left) / 2;

      if (nums[mid] > target) {
        // if mid bigger than target -> left = mid + 1
        right = mid - 1;
      } else if (nums[mid] < target) {
        // else if mid smaller than target -> right = mid - 1
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return left;
  }
}