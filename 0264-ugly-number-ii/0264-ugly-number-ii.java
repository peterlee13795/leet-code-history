class Solution {
    public int nthUglyNumber(int n) {
        // 최소 큐
        PriorityQueue<Long> pqueue = new PriorityQueue<>();

        // 중복방지용 set
        Set<Long> sets = new HashSet<>();
        
        // 팩터 (2,3,5)
        long[] factors = { 2, 3, 5 };

        // 초기값 정의
        pqueue.add(1L);
        sets.add(1L);

        long ugly = 1;

        // n회 반복
        for (int i = 1; i <= n; i++) {
            ugly = pqueue.poll();

            for (long factor: factors) {
                long nextUgly = ugly * factor;
                if (sets.add(nextUgly)) {
                    pqueue.add(nextUgly);
                }
            }
        }

        return (int)ugly;
    }
}