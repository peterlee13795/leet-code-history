class Solution {
    public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums); // 정렬 필수
    int closest = nums[0] + nums[1] + nums[2];

    for (int i = 0; i < nums.length - 2; i++) {
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            if (Math.abs(target - sum) < Math.abs(target - closest)) {
                closest = sum;
            }

            if (sum < target) {
                left++; // 더 큰 합을 만들기 위해
            } else {
                right--; // 더 작은 합을 만들기 위해
            }
        }
    }

    return closest;
    }
}