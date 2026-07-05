class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // init left(1), right(max)
        int left = 1;
        int right = 0;
        
        
        for(int pile: piles) {
            if(right < pile) right = pile;
        }

        // while (left < right)
        while(left < right) {
            // mid speed
            int mid = left + (right - left) / 2;

            // get required hours
            int requiredHours = 0;
            for(int pile: piles) {
                requiredHours += (pile + mid - 1) / mid;
            }

            // if required-hours equals or smaller than h, then right = mid
            if(requiredHours <= h) right = mid;
            else left = mid + 1;    
        }
        
        // return left;
        return left;
    }
}