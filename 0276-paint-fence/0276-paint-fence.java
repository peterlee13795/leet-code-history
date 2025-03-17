class Solution {
    public int numWays(int n, int k) {
        if(n == 1) return k;
        if (n < 2) return k * k;
    
        // same, diff
        int same = k;
        int diff = k * (k - 1);

        int counts = same + diff;

        for (int i = 2; i < n; i++) {
        int oldSame = same;

        // same[n] = diff[n-1] * k;
        same = diff;

        // diff[n] = (same[n-1] * (k-1)) + diff[k-1] * (k-1))
        diff = (oldSame * (k - 1)) + (diff * (k - 1));

        // dp[n] ] same[n] + diff[n]
        counts = same + diff;
        }
        return counts;
    }
}