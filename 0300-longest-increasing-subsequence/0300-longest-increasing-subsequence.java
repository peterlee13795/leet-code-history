class Solution {
    public int lengthOfLIS(int[] nums) {
        // init (subSequence)
        List<Integer> subSequence = new ArrayList<>();

        // iterate nums
        for(int num: nums) {
            // binarySearch to find out the location of each number
            int index = binarySearch(subSequence, num);

            if(index >= subSequence.size()) {
                // add if position is larger than subSequence length
                subSequence.add(num);
            } else {
                // set if position is equals or smaller than subSequence length
                subSequence.set(index, num);
            }
        }

        // return subSequence length (answer)
        return subSequence.size();

    }

    int binarySearch(List<Integer> subSequence, int target) {
        // init (left, right)
        int left = 0;
        int right = subSequence.size();

        // binary search iterate
        while(left < right) {
            // get mid
            int mid = left + (right - left) / 2;

            if(subSequence.get(mid) < target) {
                // if mid value is smaller than target => left = mid + 1
                left = mid + 1;
            } else {
                // else => right = mid
                right = mid;
            }
        }
        
        // return left
        return left;

    }
}