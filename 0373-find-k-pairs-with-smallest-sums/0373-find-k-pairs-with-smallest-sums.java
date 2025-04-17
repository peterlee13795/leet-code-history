class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));

        // nums1[i]와 nums2[0] 쌍을 힙에 먼저 넣기 (nums2의 인덱스를 같이 저장)
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[] {nums1[i], nums2[0], 0});
        }

        while (!minHeap.isEmpty() && result.size() < k) {
            int[] curr = minHeap.poll();
            int num1 = curr[0];
            int num2 = curr[1];
            int idx2 = curr[2];

            result.add(Arrays.asList(num1, num2));

            // 다음 가능한 nums2 원소로 확장
            if (idx2 + 1 < nums2.length) {
                minHeap.offer(new int[] {num1, nums2[idx2 + 1], idx2 + 1});
            }
        }

        return result;
    }
}