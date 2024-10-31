class Solution {
    public boolean canJump(int[] nums) {
    int len = nums.length;
    int target = len - 1;
    boolean[] visits = new boolean[len];

    // DFS
    Stack<Integer> stack = new Stack<>();
    stack.add(0);

    while (!stack.isEmpty()) {
      int index = Math.min(stack.pop(), target);
      if (visits[index]) {
        continue;
      }
      visits[index] = true;
      if (index == target) {
        return true;
      }
      int toIndex = Math.min(index + nums[index], target);
      for (int i = index + 1; i <= toIndex; i++) {
        stack.add(i);
      }
    }
    return false;
  }
}