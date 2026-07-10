class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // if( m x k > bloomDay.length) return -1
        if ((long) m * k > bloomDay.length) return -1;

        // left, right
        // left = Math.min(bloomDay);
        // right = Math.max(bloomDay);
        int left = Integer.MAX_VALUE, right = 0;
        for(int b: bloomDay) {
            left = Math.min(left, b);
            right = Math.max(right, b);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            int bouquets = 0;
            int flowers = 0;

            for (int b : bloomDay) {
                if (b <= mid) {
                    flowers++;
                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }

            if (bouquets >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}