class Solution {
    public int findPairs(int[] nums, int k) {
    if (k < 0) return 0;  // 음수 차이는 없으므로 0 리턴

    Arrays.sort(nums);
    int left = 0, right = 1, count = 0;
    int n = nums.length;

    while (left < n && right < n) {
        if (left == right || nums[right] - nums[left] < k) {
            right++;
        } else if (nums[right] - nums[left] > k) {
            left++;
        } else {
            count++;
            left++;
            // 중복 방지
            while (left < n && nums[left] == nums[left - 1]) {
                left++;
            }
        }
    }

    return count;
}

}