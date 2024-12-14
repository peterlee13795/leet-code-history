class Solution {
    public long continuousSubarrays(int[] nums) {
        long count = 0;
        int left = 0; // 윈도우의 시작점
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 정렬된 자료구조로 윈도우 관리

        for (int right = 0; right < nums.length; right++) {
            // 현재 값을 윈도우에 추가
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // 윈도우 내 최대값과 최소값의 차이가 2를 초과하면 시작점 이동
            while (map.lastKey() - map.firstKey() > 2) {
                int leftValue = nums[left];
                map.put(leftValue, map.get(leftValue) - 1);

                // 빈 값 제거
                if (map.get(leftValue) == 0) {
                    map.remove(leftValue);
                }
                left++; // 윈도우의 시작점 이동
            }

            // 윈도우의 크기를 더함
            count += (right - left + 1);
        }

        return count;
    }
}