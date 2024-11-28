class Solution {
    public int largestAltitude(int[] gain) {
        int accm = 0;
        int max = 0;
        for(int change: gain) {
            accm += change;
            max = Math.max(max, accm);
        }
        return max;
    }
}