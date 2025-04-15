class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // three pointer

        // init(closest, size)
        int closest = Integer.MAX_VALUE;
        int size = nums.length;
        int answer = 0;


        // iterate i,j,k

        // for(0 <= i < size - 2)
        for(int i = 0; i < size - 2; i++) {
            // for(i < j < size - 1
            for(int j = i + 1; j < size - 1; j++) {
                int twoSum = nums[i] + nums[j];
                // for(j < k < size)
                for(int k = j + 1; k < size; k++) {
                    int threeSum = twoSum + nums[k];
                    int diff = Math.abs(target - threeSum);
                    if(closest > diff) {
                        closest = diff;
                        answer = threeSum;
                    }
                }
            }
        }

        return answer;
    }
}