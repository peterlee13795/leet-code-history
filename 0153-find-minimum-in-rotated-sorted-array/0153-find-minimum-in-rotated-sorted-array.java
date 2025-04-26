class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // 최소값은 mid 오른쪽에 있음
                left = mid + 1;
            } else {
                // 최소값은 mid 또는 왼쪽에 있음
                right = mid;
            }
        }

        return nums[left];
    }
}
