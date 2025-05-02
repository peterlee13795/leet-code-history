class Solution {
    private int[] prefixSums;
    private Random random;
    
    public Solution(int[] w) {
        prefixSums = new int[w.length];
        prefixSums[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + w[i];
        }
        random = new Random();
    }
    
    public int pickIndex() {
        int total = prefixSums[prefixSums.length - 1];
        int target = random.nextInt(total) + 1; // 1 이상 total 이하

        // 이진 탐색
        int left = 0, right = prefixSums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
