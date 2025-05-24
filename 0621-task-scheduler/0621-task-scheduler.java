class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25]; // 가장 많이 나온 작업 수
        int maxCount = 1;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] != maxFreq) break;
            maxCount++;
        }

        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int emptySlots = partCount * partLength + maxCount;

        return Math.max(tasks.length, emptySlots);
    }
}