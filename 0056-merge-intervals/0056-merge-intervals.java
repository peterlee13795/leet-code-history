class Solution {
    public int[][] merge(int[][] intervals) {
        // 시작 기준으로 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                // 병합
                current[1] = Math.max(current[1], next[1]);
            } else {
                // 현재를 결과에 추가하고, 다음으로 이동
                merged.add(current);
                current = next;
            }
        }

        merged.add(current); // 마지막 구간 추가

        // List<int[]> → int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}