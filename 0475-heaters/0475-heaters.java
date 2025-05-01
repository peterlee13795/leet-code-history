class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;

        for (int house : houses) {
            int dist = findClosestHeaterDist(house, heaters);
            radius = Math.max(radius, dist);
        }

        return radius;
    }

    private int findClosestHeaterDist(int house, int[] heaters) {
        int left = 0, right = heaters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] < house) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int dist1 = (right >= 0) ? Math.abs(house - heaters[right]) : Integer.MAX_VALUE;
        int dist2 = (left < heaters.length) ? Math.abs(house - heaters[left]) : Integer.MAX_VALUE;

        return Math.min(dist1, dist2);
    }
}