class Solution {
    public int singleNonDuplicate(int[] nums) {
    int left = 0, right = nums.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        // mid를 항상 짝수로 맞춰서 mid, mid+1이 쌍인지 확인
        if (mid % 2 == 1) mid--;

        if (nums[mid] == nums[mid + 1]) {
            // 쌍이 정상이면 그 이후에 정답이 있음
            left = mid + 2;
        } else {
            // 쌍이 깨졌다는 건 정답이 mid 또는 왼쪽에 있음
            right = mid;
        }
    }

    return nums[left];
}
}