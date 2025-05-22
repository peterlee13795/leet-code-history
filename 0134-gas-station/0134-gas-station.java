class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;     // 전체 주유소의 총 연료 잔량
        int currTank = 0;      // 현재까지 연료 잔량
        int startStation = 0;  // 출발할 주유소의 인덱스

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currTank += diff;

            // 현재까지의 연료가 부족하면 출발 지점을 다음으로 설정
            if (currTank < 0) {
                startStation = i + 1;
                currTank = 0;
            }
        }

        // 전체 연료가 부족하면 완주 불가
        return totalTank >= 0 ? startStation : -1;
    }
}