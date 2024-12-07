class Solution {
    public boolean verifyPreorder(int[] preorder) {
        // lowerBound는 현재 확인 중인 값의 최솟값을 정의합니다.
        int lowerBound = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int value : preorder) {
            // 현재 값이 lowerBound보다 작으면 유효하지 않은 BST
            if (value < lowerBound) {
                return false;
            }

            // 스택에서 현재 값보다 작은 값을 모두 제거
            while (!stack.isEmpty() && value > stack.peek()) {
                lowerBound = stack.pop();
            }

            // 현재 값을 스택에 추가
            stack.push(value);
        }

        return true;
    }
    
}