class Solution {
    public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int len = nums.length;
    int count = 0;

    for (int i = 0; i < len - 2; i++) {
        int left = i + 1;
        int right = len - 1;

        while (left < right) {
            int value = nums[i] + nums[left] + nums[right];

            if (value >= target) {
                right--;
            } else {
                count += right - left; // ✅ 여기가 핵심
                left++;
            }
        }
    }

    return count;
}
}