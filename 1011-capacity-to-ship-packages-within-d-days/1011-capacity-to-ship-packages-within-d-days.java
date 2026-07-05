class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // left, right
        int left = 0, right = 0;

        // right = total weight of weights
        for(int weight: weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // while(left < right)
        while(left < right) {
            // get mid
            int mid = left + (right - left) / 2;

            // requiredDays, currentWeight
            int requiredDays = 1;
            int currentWeight = 0;

            // iterate weights
            for(int weight: weights) {
                // if(currentWeight + weight > mid) => crreuntWeight = weight, requiredDays += 1,
                if(currentWeight + weight > mid) {
                    currentWeight = weight;
                    requiredDays += 1;
                } else { // else currentWeight += weight
                    currentWeight += weight;
                }
            }

            // if (requiredDays <= days) right = mid
            if(requiredDays <= days) right = mid;
            // else left + 1
            else left = mid + 1;
        }

        // return left
        return left;
    }
}