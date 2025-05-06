class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 아이디어: DP처리 + 이진탐색
        // dp: 이득 최대치
        // 이진탐색: 현재작업 시작시간과 동일하거나 바로 이전에 마친 작업 찾기

        // init
        int len = startTime.length;

        // 종료시간 기준 오름차순 정렬
        Job[] jobs = new Job[len];
        for(int i = 0 ; i < len; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (job1, job2) -> job1.end - job2.end);

        // dp 배열, 0-인덱스 처리
        int[] dp = new int[len];
        dp[0] = jobs[0].profit;

        // 반복문
        for(int i =1 ; i < len; i++) {
            // 현재 작업보다 겹치지 않은 작업을 이진탐색을 통해 검증
            int lastIndex = binarySearch(jobs, i);
            int currentProfit = jobs[i].profit;
            if(lastIndex != -1) {
                currentProfit += dp[lastIndex];
            }

            // dp[n] = Math.max(dp[n-1], profit)
            dp[i] = Math.max(dp[i - 1], currentProfit);
        }

        // return dp[n-1];
        return dp[len - 1];
    }

    private int binarySearch(Job[] jobs, int index) {
        // left, right
        int left = 0;
        int right = index - 1;

        // left <= right 이진탐색
        while(left <= right) {
            // mid 찾기
            int mid = left + (right - left) / 2;

            // if ( jobs[mid].end <= jobs[index].start ) => 겹치치 않는 작업이 있다면
            if(jobs[mid].end <= jobs[index].start) {
                //   if [ jobs[mid+1].end <= jobs[index].start ] => left = mid + 1
                if(jobs[mid + 1].end <= jobs[index].start) left = mid + 1;
                //   else return mid
                else return mid;
            } else right = mid - 1;
        }

        // return -1
        return -1;
    }

    static class Job {
        int start;
        int end;
        int profit;
        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}