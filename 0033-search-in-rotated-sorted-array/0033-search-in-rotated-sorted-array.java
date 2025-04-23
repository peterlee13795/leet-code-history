class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // 찾는 값이 중간값과 같다면 인덱스 반환
            if (nums[mid] == target) {
                return mid;
            }

            // 왼쪽 구간이 정렬되어 있는 경우
            if (nums[left] <= nums[mid]) {
                // target이 왼쪽 구간에 포함된다면
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else { // 오른쪽 구간 탐색
                    left = mid + 1;
                }
            } 
            // 오른쪽 구간이 정렬되어 있는 경우
            else {
                // target이 오른쪽 구간에 포함된다면
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else { // 왼쪽 구간 탐색
                    right = mid - 1;
                }
            }
        }

        return -1; // 찾지 못한 경우
    }
}