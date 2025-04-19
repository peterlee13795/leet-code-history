class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> answer = new ArrayList<>();
    int len = nums.length;

    if (len < 4) return answer;

    Arrays.sort(nums);

    for (int i = 0; i < len - 3; i++) {
        // 중복 제거
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        // 가지치기 - 최소합 > target → 이후는 볼 필요 없음
        if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;

        // 가지치기 - 최대합 < target → 현재 i는 너무 작음
        if ((long) nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;

        for (int j = i + 1; j < len - 2; j++) {
            // 중복 제거
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;

            // 가지치기
            if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
            if ((long) nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;

            int left = j + 1;
            int right = len - 1;

            while (left < right) {
                long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                if (sum == target) {
                    answer.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                    left++;
                    right--;

                    // 중복 제거
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    return answer;
}

}