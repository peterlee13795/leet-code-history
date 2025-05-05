class Solution {
    public int reachNumber(int target) {
    target = Math.abs(target);  // 음수 대상은 양수로 바꿔도 동일
    int sum = 0;
    int step = 0;
    
    while (true) {
        step++;
        sum += step;

        if (sum >= target && (sum - target) % 2 == 0) {
            return step;
        }
    }
}
}