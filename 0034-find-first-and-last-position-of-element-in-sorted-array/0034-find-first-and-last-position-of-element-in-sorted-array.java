class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int [] {-1, -1};
        // init left, right
        int left = 0;
        int right = nums.length - 1;

        // binary search (logn)
        while (left <= right) {
            // get mid & value
            int mid = left + (right - left) / 2;

            // if value == target => find most left & right
            if(nums[mid] == target) {
                return sameValues(nums, mid);
            }

            // if value < target => left = mid + 1
            if(nums[mid] < target) left = mid + 1;
            // else right = mid - 1
            else right = mid - 1;
        }

        // return [-1, -1]
        return new int[] {-1, -1};
    }

    int[] sameValues(int[] nums, int pivot) {
        int left = pivot;
        int right = pivot;
        boolean leftValid = true;
        boolean rightValid = true;
        while (leftValid || rightValid) {
            leftValid = left > 0 && nums[left - 1] == nums[left];
            rightValid = right < nums.length - 1 && nums[right + 1] == nums[right];
            if(leftValid) {
                left--;
            }

            if(rightValid) {
                right++;
            }

        }
        // find left & right
        return new int[] {left, right};
    }
}