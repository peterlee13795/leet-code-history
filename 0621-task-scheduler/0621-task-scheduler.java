class Solution {
    public int leastInterval(char[] tasks, int n) {
        // init (frequents)
        int[] frequents = new int[26];
        for(char task: tasks) frequents[task - 'A']++;

        // 가장 다양하게 나온 종류 확인
        Arrays.sort(frequents);
        int maxFrequent = frequents[25];
        int maxCount = 1;
        for(int i = 24; i >= 0 ;i--) {
            if(maxFrequent != frequents[i]) break;
            maxCount++;
        }

        // 반복수 = 최대수 - 1
        // 1회반복 = n + 1

        // 결과값 = 반복수 * 1회반복 + 최대수
        int emptySlots = (maxFrequent -1) * (n + 1) + maxCount;

        // return Math.max(결과값, length);
        return Math.max(emptySlots, tasks.length);
    }
}