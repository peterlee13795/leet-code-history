class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // 시작 기준점을 -1로 초기화
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // 열린 괄호는 인덱스를 스택에 push
                stack.push(i);
            } else {
                // 닫힌 괄호인 경우 짝 찾기 위해 pop
                stack.pop();

                if (stack.isEmpty()) {
                    // 스택이 비었으면 현재 인덱스를 기준점으로 push
                    stack.push(i);
                } else {
                    // 현재 인덱스 - 마지막 열린 괄호 인덱스 = 유효한 길이
                    int len = i - stack.peek();
                    maxLength = Math.max(maxLength, len);
                }
            }
        }

        return maxLength;
    }
}
