class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int end = 0;      // 현재 점프에서 도달할 수 있는 최대 위치
        int farthest = 0; // 현재까지 탐색 중 가장 멀리 갈 수 있는 위치

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            // 현재 점프의 끝에 도달했을 때
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}