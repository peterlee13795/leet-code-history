class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    int len = nums.length;

    // required list
    List<Integer> zeroList = new ArrayList<>();
    int[] left = new int[len];
    int[] right = new int[len];
    int longest = -1;

    // left consequence
    for (int i = 0, leftVal = 0, rightVal = 0; i < len; i++) {
      left[i] = leftVal;
      if (nums[i] == 0) {
        zeroList.add(i);
        leftVal = 0;
      } else {
        leftVal++;
        longest = Math.max(longest, leftVal);
      }
      right[len - 1 - i] = rightVal;
      if (nums[len - 1 - i] == 0) {
        rightVal = 0;
      } else {
        rightVal++;
      }
    }
    if (longest >= len - 1) {
      return len;
    }

    // zero iterate
    for (int zeroIndex : zeroList) {
      if (zeroIndex == 0) {
        longest = Math.max(longest, right[0] + 1);
      } else if (zeroIndex == len - 1) {
        longest = Math.max(longest, left[len - 1] + 1);
      } else {
        longest = Math.max(longest, left[zeroIndex] + right[zeroIndex] + 1);
      }
    }

    // return
    return longest;
  }
}