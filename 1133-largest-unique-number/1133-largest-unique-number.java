class Solution {
    public int largestUniqueNumber(int[] nums) {
    int[] counts = new int[1001]; // 0 <= nums[i] <= 1000
    for (int num : nums) {
      counts[num]++; // 개수 증분
    }

    for (int i = 1000; i >= 0; i--) {
      if (counts[i] == 1) { // unique largest
        return i;
      }
    }
    return -1;
  }
}