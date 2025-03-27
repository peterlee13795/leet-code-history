class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // 논문 인용 횟수 정렬
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 h-index 후보 값
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}