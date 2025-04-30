class Solution {
    public boolean find132pattern(int[] nums) {
        // second variable
        int second = Integer.MIN_VALUE;

        // stack
        Stack<Integer> stack = new Stack<>();

        // iterate num backward
        for(int i = nums.length - 1; i >= 0 ; i--) {
            // if current value is smaller than second => returne true
            if(nums[i] < second) return true;

            // if current value is larger than stack pop => set second variable, to ensure that nums[j] > nums[k]
            while(!stack.isEmpty() && nums[i] > stack.peek()) second = stack.pop();

            // put current value into stack
            stack.add(nums[i]);
        }

        // return false
        return false;
    }
}