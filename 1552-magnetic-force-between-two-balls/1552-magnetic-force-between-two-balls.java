class Solution {
    int len = 0;
    public int maxDistance(int[] positions, int m) {
        // position 정렬 (n x logn)
        Arrays.sort(positions);
        len = positions.length;

        // left = 1(최소거리)
        int left = 1;
        int right =positions[len - 1] - positions[0];

        // while left < right
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(positions, m, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // return left
        return right;
    }

    private boolean check(int[] positions, int m, int mid) {
        int balls = 1;
        int prev = positions[0];

        // position 반복
        for(int i =1 ; i < len; i++) {
            // 이전~다음 거리 비교했을 때, mid보다 작다면 pass
            if(positions[i] - prev < mid) {
                continue;
            }
            // 같거나 크다면, balls++
            prev = positions[i];
            balls++;
        }

        // return balls >= m
        return balls >= m;
    }
}