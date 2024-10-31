class Solution {
    public void rotate(int[] nums, int k) {
    int len = nums.length;
    int[] newValues = new int[len];
    k = k % len;
    for (int i = 0; i < len; i++) {
      int newIndex = (i + k) % len;
      newValues[newIndex] = nums[i];
    }
    for (int i = 0; i < len; i++) {
      nums[i] = newValues[i];
    }
  }
}