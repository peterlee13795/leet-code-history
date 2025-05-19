class Solution {
    public int jump(int[] nums) {
        int jumpCount = 0;
        int currentTargetIndex = 0;
        int nextTargetIndex = 0;
        for (int i = 0, len = nums.length; i < len - 1; i++) {
            nextTargetIndex = Math.max(nextTargetIndex, i + nums[i]); // jump 가능한 최대 위치
            if (i == currentTargetIndex) { // 점프 위치에 닿으면 + 1
                currentTargetIndex = nextTargetIndex;
                jumpCount++;
            }
        }
        return jumpCount;
    }
}