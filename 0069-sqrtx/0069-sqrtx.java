class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int lo = 1, hi = x;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid <= x / mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}