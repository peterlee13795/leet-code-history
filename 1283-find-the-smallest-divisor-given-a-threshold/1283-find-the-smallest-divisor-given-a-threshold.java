class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // left=1,right=(Math.max(nums) * 2) + 1
        int left = 1;
        int right = 0;
        int max = 0;
        for(int num: nums) {
            max = Math.max(num, max);
        }
        right = (max * 2) + 1;

        // while
        while(left < right) {
            // get mid
            int mid = left + (right - left) / 2;

            // get sum
            int sum = 0;
            for(int num: nums) {
                sum += (num + mid - 1) / mid;
            }

            // if sum is equals or smaller than threshold, then right = mid
            if(sum <= threshold) right = mid;
            // else left = mid + 1
            else left = mid + 1;
        }
        // return left
        return left;
    }
}