class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // 종료지점 기준 정렬
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrowCount = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // 현재 풍선의 시작점이 이전 화살 범위를 벗어났다면 새로운 화살 필요
            if (points[i][0] > arrowPos) {
                arrowCount++;
                arrowPos = points[i][1];
            }
        }
        return arrowCount;
    }
}
