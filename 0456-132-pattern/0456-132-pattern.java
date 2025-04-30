class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>(); // nums[j] 후보들 저장
        int second = Integer.MIN_VALUE;       // nums[k] 역할 ('2'에 해당)

        // 뒤에서부터 스캔
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true; // 132 패턴 성립
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                // nums[i]보다 작은 값들을 꺼내서 second 갱신
                second = stack.pop();
            }
            stack.push(nums[i]); // 현재 값은 nums[j] 후보로 스택에 추가
        }

        return false;
    }
}