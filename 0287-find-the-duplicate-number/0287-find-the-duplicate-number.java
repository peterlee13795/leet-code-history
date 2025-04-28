class Solution {
    public int findDuplicate(int[] nums) {
    // 1. detect cycle (Tortoise and Hare)
    int slow = nums[0];
    int fast = nums[0];

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    // 2. find entrance
    slow = nums[0];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }
}