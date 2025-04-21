class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // 1단계: nums[i] < nums[i + 1] 인 가장 마지막 위치 i 찾기
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 2단계: i 뒤쪽에서 nums[i]보다 큰 수 중 가장 작은 값과 swap
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3단계: i 뒤의 수들을 오름차순 정렬 (역순으로 뒤집기)
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}