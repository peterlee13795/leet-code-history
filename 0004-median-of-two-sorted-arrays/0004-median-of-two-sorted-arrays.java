class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // get target index ( = nums1.length + nums2.length / 2
        int llen = nums1.length;
        int rlen = nums2.length;
        int target = (llen + rlen) / 2;

        // int beforeValue;
        int beforeValue = 0;

        // int current, left, right
        int left = 0, right = 0;

        // iterate Math.max(nums1.length, nums2.length)
        int total =llen + rlen;
        for(int current =0 ; current < total; current++) {
            // if left or right index is greater than len, then choose other side
            int leftValue = Integer.MAX_VALUE, rightValue = Integer.MAX_VALUE;

            if(left < llen) leftValue = nums1[left];
            if(right < rlen) rightValue = nums2[right];

            // compare left and right
            if(leftValue <= rightValue) { // if left smaller, increase it, leftVal = nums1[left]
                if(current == target) return (llen + rlen) % 2 == 1 ? leftValue : (beforeValue + leftValue) / 2.0d;
                beforeValue = leftValue;
                left++;
            } else { // otherwise increase right leftVal = nums2[right]
                if(current == target) return (llen + rlen) % 2 == 1 ? rightValue : (beforeValue + rightValue) / 2.0d;
                beforeValue = rightValue;
                right++;
            }
        }

        return -1;
    }
}